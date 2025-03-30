package com.mapfre.welcomepack.payload;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class ORcpPmrP {

	@JsonAlias("oRcpPmrS")
	@JsonProperty("receipt")
	private ORcpPmrS oRcpPmrS = null;

	public ORcpPmrS getoRcpPmrS() {
		return oRcpPmrS;
	}

	public void setoRcpPmrS(ORcpPmrS oRcpPmrS) {
		this.oRcpPmrS = oRcpPmrS;
	}

}