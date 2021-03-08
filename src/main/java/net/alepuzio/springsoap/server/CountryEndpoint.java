package net.alepuzio.springsoap.server;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import net.alepuzio.springsoap.gen.GetCountryRequest;
import net.alepuzio.springsoap.gen.GetCountryResponse;
/*
 * https://spring.io/guides/gs/producing-web-service/
 * */
@Endpoint
public class CountryEndpoint {
	private static final String NAMESPACE_URI = "http://alepuzio.net/springsoap/gen";

	private CountryRepository countryRepository;

	@Autowired
	public CountryEndpoint(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
	@ResponsePayload
	public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
		GetCountryResponse response = new GetCountryResponse();
		response.setCountry(countryRepository.findCountry(request.getName()));
		System.out.println("response.getCountry(): " + response.getCountry());
		return response;
	}
}