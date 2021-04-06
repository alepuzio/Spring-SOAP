package net.alepuzio.springsoap.server.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import net.alepuzio.springsoap.GetCountryRequest;
import net.alepuzio.springsoap.GetCountryResponse;

/**
 * @overview: implementation of the client
 * */
public class CountryClient extends WebServiceGatewaySupport {

	/**
	 * @return the response
	 * @param country: code of the country
	 * the classes GetCountryRequest and GetCountryResponse are created by pom automatically
	 * */
    public GetCountryResponse getCountry(String country) {
        GetCountryRequest request = new GetCountryRequest();
        request.setName(country);
        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive(request);
        return response;
    }
}