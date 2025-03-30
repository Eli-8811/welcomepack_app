package com.mapfre.welcomepack.payload;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class ORcpErcC {

	@JsonAlias("oRcpPmiPT")
	@JsonProperty("premiumReceipts")
	private List<ORcpPmiP> oRcpPmiPT = null;

	@JsonAlias("oRcpPmrP")
	@JsonProperty("receipts")
	private ORcpPmrP oRcpPmrP = null;

	public List<ORcpPmiP> getoRcpPmiPT() {
		return oRcpPmiPT;
	}

	public void setoRcpPmiPT(List<ORcpPmiP> oRcpPmiPT) {
		this.oRcpPmiPT = oRcpPmiPT;
	}

	public ORcpPmrP getoRcpPmrP() {
		return oRcpPmrP;
	}

	public void setoRcpPmrP(ORcpPmrP oRcpPmrP) {
		this.oRcpPmrP = oRcpPmrP;
	}

}
