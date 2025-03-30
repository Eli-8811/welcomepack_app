package com.mapfre.welcomepack.payload;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class ORcpPmiP {

	@JsonAlias("oRcpPmiS")
	@JsonProperty("premiumReceipt")
	private ORcpPmiS oRcpPmiS = null;

	public ORcpPmiS getoRcpPmiS() {
		return oRcpPmiS;
	}

	public void setoRcpPmiS(ORcpPmiS oRcpPmiS) {
		this.oRcpPmiS = oRcpPmiS;
	}

}
