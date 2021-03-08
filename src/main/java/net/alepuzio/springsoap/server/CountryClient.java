package net.alepuzio.springsoap.server;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import net.alepuzio.springsoap.GetCountryRequest;
import net.alepuzio.springsoap.GetCountryResponse;

public class CountryClient extends WebServiceGatewaySupport {

    public GetCountryResponse getCountry(String country) {
        GetCountryRequest request = new GetCountryRequest();
        request.setName(country);
        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive(request);
        return response;
    }
}