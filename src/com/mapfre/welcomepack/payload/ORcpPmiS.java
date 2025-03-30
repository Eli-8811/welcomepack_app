package com.mapfre.welcomepack.payload;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class ORcpPmiS {

	@JsonAlias("agnMdf")
	@JsonProperty("agentModification")
	private String agnMdf = null;

	@JsonAlias("agnMdfMvmVal")
	@JsonProperty("agentModificationMovementValue")
	private BigDecimal agnMdfMvmVal = null;

	@JsonAlias("aplEnrSqn")
	@JsonProperty("applicationEndorsementValue")
	private BigDecimal aplEnrSqn = null;

	@JsonAlias("aplVal")
	@JsonProperty("applicationValue")
	private BigDecimal aplVal = null;

	@JsonAlias("bnsAmn")
	@JsonProperty("bonusAmount")
	private BigDecimal bnsAmn = null;

	@JsonAlias("cmpVal")
	@JsonProperty("company")
	private BigDecimal cmpVal = null;

	@JsonAlias("cmsAmn")
	@JsonProperty("commissionAmount")
	private BigDecimal cmsAmn = null;

	@JsonAlias("enrIsuDat")
	@JsonProperty("endorsementIssueDate")
	private Long enrIsuDat = null;

	@JsonAlias("enrSqn")
	@JsonProperty("endorsementValue")
	private BigDecimal enrSqn = null;

	@JsonAlias("exrVal")
	@JsonProperty("exchangeRateValue")
	private BigDecimal exrVal = null;

	@JsonAlias("inmVal")
	@JsonProperty("installmentValue")
	private Integer inmVal = null;

	@JsonAlias("itrAmn")
	@JsonProperty("interestAmount")
	private BigDecimal itrAmn = null;

	@JsonAlias("itrTaxAmn")
	@JsonProperty("interestTaxAmount")
	private BigDecimal itrTaxAmn = null;

	@JsonAlias("lobVal")
	@JsonProperty("lineOfBusiness")
	private BigDecimal lobVal = null;

	@JsonAlias("nt0Amn")
	@JsonProperty("netAmount")
	private BigDecimal nt0Amn = null;

	@JsonAlias("plyVal")
	@JsonProperty("policyValue")
	private String plyVal = null;

	@JsonAlias("pmsMdf")
	@JsonProperty("paymentPlanModified")
	private String pmsMdf = null;

	@JsonAlias("pmsMdfMvmVal")
	@JsonProperty("paymentScheduleModificationMovementValue")
	private BigDecimal pmsMdfMvmVal = null;

	@JsonAlias("pmsVal")
	@JsonProperty("paymentScheduleValue")
	private BigDecimal pmsVal = null;

	@JsonAlias("rcpAmn")
	@JsonProperty("receiptAmount")
	private BigDecimal rcpAmn = null;

	@JsonAlias("rcpFrsAxlVal")
	@JsonProperty("firstAuxiliaryFieldReceipt")
	private String rcpFrsAxlVal = null;

	@JsonAlias("rcpScnAxlVal")
	@JsonProperty("secondAuxiliaryFieldReceipt")
	private String rcpScnAxlVal = null;

	@JsonAlias("rcpVal")
	@JsonProperty("receiptValue")
	private BigDecimal rcpVal = null;

	@JsonAlias("smlVal")
	@JsonProperty("simulateValue")
	private BigDecimal smlVal = null;

	@JsonAlias("smnVal")
	@JsonProperty("quickQuotation")
	private String smnVal = null;

	@JsonAlias("srcAmn")
	@JsonProperty("surchargeAmount")
	private BigDecimal srcAmn = null;

	@JsonAlias("taxAmn")
	@JsonProperty("taxAmount")
	private BigDecimal taxAmn = null;

	@JsonAlias("totCmsAmn")
	@JsonProperty("totalCommissionAmount")
	private BigDecimal totCmsAmn = null;

	public String getAgnMdf() {
		return agnMdf;
	}

	public void setAgnMdf(String agnMdf) {
		this.agnMdf = agnMdf;
	}

	public BigDecimal getAgnMdfMvmVal() {
		return agnMdfMvmVal;
	}

	public void setAgnMdfMvmVal(BigDecimal agnMdfMvmVal) {
		this.agnMdfMvmVal = agnMdfMvmVal;
	}

	public BigDecimal getAplEnrSqn() {
		return aplEnrSqn;
	}

	public void setAplEnrSqn(BigDecimal aplEnrSqn) {
		this.aplEnrSqn = aplEnrSqn;
	}

	public BigDecimal getAplVal() {
		return aplVal;
	}

	public void setAplVal(BigDecimal aplVal) {
		this.aplVal = aplVal;
	}

	public BigDecimal getBnsAmn() {
		return bnsAmn;
	}

	public void setBnsAmn(BigDecimal bnsAmn) {
		this.bnsAmn = bnsAmn;
	}

	public BigDecimal getCmpVal() {
		return cmpVal;
	}

	public void setCmpVal(BigDecimal cmpVal) {
		this.cmpVal = cmpVal;
	}

	public BigDecimal getCmsAmn() {
		return cmsAmn;
	}

	public void setCmsAmn(BigDecimal cmsAmn) {
		this.cmsAmn = cmsAmn;
	}

	public Long getEnrIsuDat() {
		return enrIsuDat;
	}

	public void setEnrIsuDat(Long enrIsuDat) {
		this.enrIsuDat = enrIsuDat;
	}

	public BigDecimal getEnrSqn() {
		return enrSqn;
	}

	public void setEnrSqn(BigDecimal enrSqn) {
		this.enrSqn = enrSqn;
	}

	public BigDecimal getExrVal() {
		return exrVal;
	}

	public void setExrVal(BigDecimal exrVal) {
		this.exrVal = exrVal;
	}

	public Integer getInmVal() {
		return inmVal;
	}

	public void setInmVal(Integer inmVal) {
		this.inmVal = inmVal;
	}

	public BigDecimal getItrAmn() {
		return itrAmn;
	}

	public void setItrAmn(BigDecimal itrAmn) {
		this.itrAmn = itrAmn;
	}

	public BigDecimal getItrTaxAmn() {
		return itrTaxAmn;
	}

	public void setItrTaxAmn(BigDecimal itrTaxAmn) {
		this.itrTaxAmn = itrTaxAmn;
	}

	public BigDecimal getLobVal() {
		return lobVal;
	}

	public void setLobVal(BigDecimal lobVal) {
		this.lobVal = lobVal;
	}

	public BigDecimal getNt0Amn() {
		return nt0Amn;
	}

	public void setNt0Amn(BigDecimal nt0Amn) {
		this.nt0Amn = nt0Amn;
	}

	public String getPlyVal() {
		return plyVal;
	}

	public void setPlyVal(String plyVal) {
		this.plyVal = plyVal;
	}

	public String getPmsMdf() {
		return pmsMdf;
	}

	public void setPmsMdf(String pmsMdf) {
		this.pmsMdf = pmsMdf;
	}

	public BigDecimal getPmsMdfMvmVal() {
		return pmsMdfMvmVal;
	}

	public void setPmsMdfMvmVal(BigDecimal pmsMdfMvmVal) {
		this.pmsMdfMvmVal = pmsMdfMvmVal;
	}

	public BigDecimal getPmsVal() {
		return pmsVal;
	}

	public void setPmsVal(BigDecimal pmsVal) {
		this.pmsVal = pmsVal;
	}

	public BigDecimal getRcpAmn() {
		return rcpAmn;
	}

	public void setRcpAmn(BigDecimal rcpAmn) {
		this.rcpAmn = rcpAmn;
	}

	public String getRcpFrsAxlVal() {
		return rcpFrsAxlVal;
	}

	public void setRcpFrsAxlVal(String rcpFrsAxlVal) {
		this.rcpFrsAxlVal = rcpFrsAxlVal;
	}

	public String getRcpScnAxlVal() {
		return rcpScnAxlVal;
	}

	public void setRcpScnAxlVal(String rcpScnAxlVal) {
		this.rcpScnAxlVal = rcpScnAxlVal;
	}

	public BigDecimal getRcpVal() {
		return rcpVal;
	}

	public void setRcpVal(BigDecimal rcpVal) {
		this.rcpVal = rcpVal;
	}

	public BigDecimal getSmlVal() {
		return smlVal;
	}

	public void setSmlVal(BigDecimal smlVal) {
		this.smlVal = smlVal;
	}

	public String getSmnVal() {
		return smnVal;
	}

	public void setSmnVal(String smnVal) {
		this.smnVal = smnVal;
	}

	public BigDecimal getSrcAmn() {
		return srcAmn;
	}

	public void setSrcAmn(BigDecimal srcAmn) {
		this.srcAmn = srcAmn;
	}

	public BigDecimal getTaxAmn() {
		return taxAmn;
	}

	public void setTaxAmn(BigDecimal taxAmn) {
		this.taxAmn = taxAmn;
	}

	public BigDecimal getTotCmsAmn() {
		return totCmsAmn;
	}

	public void setTotCmsAmn(BigDecimal totCmsAmn) {
		this.totCmsAmn = totCmsAmn;
	}
	
}