package net.alepuzio.springsoap.server;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
/*
 * https://spring.io/guides/gs/producing-web-service/
 * */
@EnableWs//customize the component to a web service configuration 
@Configuration//declares this class as factory of the bean managed by Spring
/**
 * @overview Configure the web service
 * */
public class WebServiceConfig extends WsConfigurerAdapter {
	
	@Bean//the return type is managed by Spring
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);//set application context
		servlet.setTransformWsdlLocations(true); //set relative address locations in the WSDL  to be transformed using the request URI 
		return new ServletRegistrationBean<MessageDispatcherServlet>(servlet, EnumWSConfig.URL_MAPPING.value());
	}

	@Bean(name = "countries")//the return type is managed by Spring, <i>name/i> is an alias
	/**
	 * @return the binding of SOAP 1.1
	 * @param countriesSchema */
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName(EnumWSConfig.PORT_TYPE_NAME.value());//name of the port
		wsdl11Definition.setLocationUri(EnumWSConfig.LOCATION_URI.value());//SOAP Address location.
		wsdl11Definition.setTargetNamespace(EnumWSConfig.TARGET_NAMESPACE.value());
		/*
		target namespace of the schema
		argetNamespace is the expected namespace of the instances regardless of the namespace of the schema documents and any other namespace specified in the instance document.
		*/
		wsdl11Definition.setSchema(countriesSchema);//set the xsd
		return wsdl11Definition;
	}

	@Bean//method managed by Spring
	/**
	 * @return schema xsd
	 * */
	public XsdSchema countriesSchema() {
		return new SimpleXsdSchema(new ClassPathResource(EnumWSConfig.XSD_DECLARATION.value()));
	}
}
