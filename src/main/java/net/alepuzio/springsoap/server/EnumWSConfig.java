package net.alepuzio.springsoap.server;

/**
 * @overview enumeration of the constants in the web service infrastructure
 * */
public enum EnumWSConfig {

	//TARGET_NAMESPACE("http://spring.io/guides/gs-producing-web-service"),
	TARGET_NAMESPACE("http://alepuzio.net/springsoap"),
	LOCATION_URI("/ws"),
	PORT_TYPE_NAME("CountriesPort"),
	XSD_DECLARATION("countries.xsd"),
	URL_MAPPING("/ws/*"),
	DEFAULT_URI("http://localhost:{port}/ws"),
	CONTEXT_PATH("net.alepuzio.springsoap")//io.spring.guides.gs_producing_web_service
	;
	
	private EnumWSConfig(String newValue) {
		this.value = newValue;
	}

	private String value;

	public String value() {
		return value;
	}

}
