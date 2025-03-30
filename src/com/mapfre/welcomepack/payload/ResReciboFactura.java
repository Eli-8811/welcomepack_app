package com.mapfre.welcomepack.payload;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ResReciboFactura {

    @JsonProperty("plyVal")
    private String plyVal;

    @JsonProperty("rcpVal")
    private String rcpVal;

    @JsonProperty("txrVal")
    private String txrVal;

    @JsonProperty("folVal")
    private String folVal;

    @JsonProperty("folTax")
    private String folTax;

    @JsonProperty("prvDat")
    private String prvDat;

    public String getPlyVal() {
        return plyVal;
    }

    public void setPlyVal(String plyVal) {
        this.plyVal = plyVal;
    }

    public String getRcpVal() {
        return rcpVal;
    }

    public void setRcpVal(String rcpVal) {
        this.rcpVal = rcpVal;
    }

    public String getTxrVal() {
        return txrVal;
    }

    public void setTxrVal(String txrVal) {
        this.txrVal = txrVal;
    }

    public String getFolVal() {
        return folVal;
    }

    public void setFolVal(String folVal) {
        this.folVal = folVal;
    }

    public String getFolTax() {
        return folTax;
    }

    public void setFolTax(String folTax) {
        this.folTax = folTax;
    }

    public String getPrvDat() {
        return prvDat;
    }

    public void setPrvDat(String prvDat) {
        this.prvDat = prvDat;
    }
    
}