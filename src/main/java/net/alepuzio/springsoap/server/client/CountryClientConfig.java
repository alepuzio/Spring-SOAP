package net.alepuzio.springsoap.server.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import net.alepuzio.springsoap.server.EnumWSConfig;

@Configuration
/**
 * @overview: this class is identified by Spring container as
 * a factory of @Bean. 
 * */
public class CountryClientConfig {

    @Bean
    /**
     * the return type will be managed by Spring
     * @return marshaller with setted contextpath  
     * */
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(EnumWSConfig.CONTEXT_PATH.value());
        return marshaller;
    }
    
    @Bean
    /**
     * the return type will be managed by Spring
     * @return marshaller with setted contextpath  
     * */
    public CountryClient countryClient(Jaxb2Marshaller marshaller) {
        CountryClient client = new CountryClient();
        client.setDefaultUri(EnumWSConfig.DEFAULT_URI.value());
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}