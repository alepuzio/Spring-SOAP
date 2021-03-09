package net.alepuzio.springsoap.server;

public enum EnumVarious {

	//TARGET_NAMESPACE("http://spring.io/guides/gs-producing-web-service");
	TARGET_NAMESPACE("http://alepuzio.net/springsoap")
	;
	
	private EnumVarious(String newValue) {
		this.value = newValue;
	}

	private String value;

	public String value() {
		return value;
	}

}
