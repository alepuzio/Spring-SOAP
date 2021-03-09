package net.alepuzio.springsoap;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
/*
 * https://spring.io/guides/gs/producing-web-service/
 * */
@SpringBootApplication
//@PropertySource({ "classpath:src/main/resources/config/env-${build.profile.id}.properties" })
@PropertySource({ "classpath:config/env-personal-${build.profile.id}.properties" })
public class ProducingWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducingWebServiceApplication.class, args);
	}
}