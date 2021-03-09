package net.alepuzio.springsoap.server;

public enum EnumWSConfig {

	TARGET_NAMESPACE("http://spring.io/guides/gs-producing-web-service"),
	//TARGET_NAMESPACE("http://alepuzio.net/springsoap"),
	LOCATION_URI("/ws"),
	PORT_TYPE_NAME("CountriesPort"),
	XSD_DECLARATION("countries.xsd"),
	URL_MAPPING("/ws/*"),
	DEFAULT_URI("http://localhost:8080/ws"),
	CONTEXT_PATH("io.spring.guides.gs_producing_web_service")//net.alepuzio.springsoap
	;
	
	private EnumWSConfig(String newValue) {
		this.value = newValue;
	}

	private String value;

	public String value() {
		return value;
	}

}
