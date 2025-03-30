package com.mapfre.welcomepack.payload;

public class ReqReceipt {
	
	private String aplEnrSqn;
    private String aplVal;
    private String enrSqn;
    
    public ReqReceipt(String aplEnrSqn, String aplVal, String enrSqn) {
        this.aplEnrSqn = aplEnrSqn;
        this.aplVal = aplVal;
        this.enrSqn = enrSqn;
    }
    
	public String getAplEnrSqn() {
		return aplEnrSqn;
	}
	public void setAplEnrSqn(String aplEnrSqn) {
		this.aplEnrSqn = aplEnrSqn;
	}
	public String getAplVal() {
		return aplVal;
	}
	public void setAplVal(String aplVal) {
		this.aplVal = aplVal;
	}
	public String getEnrSqn() {
		return enrSqn;
	}
	public void setEnrSqn(String enrSqn) {
		this.enrSqn = enrSqn;
	}

}
