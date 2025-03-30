package com.mapfre.welcomepack.payload;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class ORcpErcPC {

	@JsonAlias("oRcpErcC")
	@JsonProperty("premiumReceiptList")
	private ORcpErcC oRcpErcC = null;

	public ORcpErcC getoRcpErcC() {
		return oRcpErcC;
	}

	public void setoRcpErcC(ORcpErcC oRcpErcC) {
		this.oRcpErcC = oRcpErcC;
	}

}

