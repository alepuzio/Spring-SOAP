package net.alepuzio.springsoap.server;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import net.alepuzio.springsoap.GetCountryRequest;
import net.alepuzio.springsoap.GetCountryResponse;


/**
 * https://spring.io/guides/gs/producing-web-service/
 * 
 * */
@Endpoint//identifies this class as an endpoint
public class CountryEndpoint {

	//TODO create class
	private static final String NAMESPACE_URI = "http://alepuzio.net/springsoap";//"https://spring.io/guides/gs/producing-web-service/";

	private CountryRepository countryRepository;

	@Autowired//this constructor is managed by Spring, no explicit call by the source code
	public CountryEndpoint(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")//identifies this methoda s responsable of the payload processing
	@ResponsePayload//declare that the returned type will be put in the response paylod
	/**
	 * @return the response of the ws
	 * @param request: http request
	 * 
	 * */
	public GetCountryResponse getCountry(@RequestPayload/*this param is in the request payload*/ GetCountryRequest request) {
		GetCountryResponse response = new GetCountryResponse();
		response.setCountry(countryRepository.findCountry(request.getName()));
		System.out.println("response.getCountry(): " + response.getCountry());//TODO put log
		return response;
	}
}