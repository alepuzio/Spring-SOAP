package net.alepuzio.springsoap;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
/*
 * https://spring.io/guides/gs/producing-web-service/
 * */
@SpringBootApplication//scan the package and runs the application
@PropertySource({ "classpath:application.properties" })//load the properties file of the application
public class ProducingWebServiceApplication {

	/*
	 * it runs the applications*/
	public static void main(String[] args) {
		SpringApplication.run(ProducingWebServiceApplication.class, args);
	}
}