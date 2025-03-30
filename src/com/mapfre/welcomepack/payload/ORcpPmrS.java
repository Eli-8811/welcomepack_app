package com.mapfre.welcomepack.payload;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class ORcpPmrS {

	@JsonAlias("acgDat")
	@JsonProperty("accountingDate")
	private Long acgDat = null;

	@JsonAlias("agnCpeNam")
	@JsonProperty("agentName")
	private String agnCpeNam = null;

	@JsonAlias("agnVal")
	@JsonProperty("agentValue")
	private BigDecimal agnVal = null;

	@JsonAlias("aplVal")
	@JsonProperty("applicationValue")
	private BigDecimal aplVal = null;

	@JsonAlias("cinTypNam")
	@JsonProperty("coinsuranceType")
	private String cinTypNam = null;

	@JsonAlias("cinTypVal")
	@JsonProperty("coinsuranceTypeValue")
	private String cinTypVal = null;

	@JsonAlias("cloCmpVal")
	@JsonProperty("collectionCompanyValue")
	private BigDecimal cloCmpVal = null;

	@JsonAlias("cloTypNam")
	@JsonProperty("collectionTypeName")
	private String cloTypNam = null;

	@JsonAlias("cloTypVal")
	@JsonProperty("collectionTypeValue")
	private String cloTypVal = null;

	@JsonAlias("cmpVal")
	@JsonProperty("company")
	private BigDecimal cmpVal = null;

	@JsonAlias("cmsDnt")
	@JsonProperty("commissionDiscount")
	private String cmsDnt = null;

	@JsonAlias("crnNam")
	@JsonProperty("currencyName")
	private String crnNam = null;

	@JsonAlias("crnVal")
	@JsonProperty("currency")
	private BigDecimal crnVal = null;

	@JsonAlias("exrVal")
	@JsonProperty("exchangeRateValue")
	private BigDecimal exrVal = null;

	@JsonAlias("lobVal")
	@JsonProperty("lineOfBusiness")
	private BigDecimal lobVal = null;

	@JsonAlias("mnrCpeNam")
	@JsonProperty("managerName")
	private String mnrCpeNam = null;

	@JsonAlias("mnrTypNam")
	@JsonProperty("nameTypeManager")
	private String mnrTypNam = null;

	@JsonAlias("mnrTypVal")
	@JsonProperty("managerType")
	private String mnrTypVal = null;

	@JsonAlias("mnrVal")
	@JsonProperty("managerValue")
	private String mnrVal = null;

	@JsonAlias("mvmVal")
	@JsonProperty("movementValue")
	private BigDecimal mvmVal = null;

	@JsonAlias("ntcVal")
	@JsonProperty("noticeValue")
	private String ntcVal = null;

	@JsonAlias("ovrVal")
	@JsonProperty("overdueValue")
	private String ovrVal = null;

	@JsonAlias("plyVal")
	@JsonProperty("policyValue")
	private String plyVal = null;

	@JsonAlias("pmrSlc")
	@JsonProperty("selection")
	private String pmrSlc = null;

	@JsonAlias("pmsVal")
	@JsonProperty("paymentScheduleValue")
	private BigDecimal pmsVal = null;

	@JsonAlias("pntQntVal")
	@JsonProperty("timesPrintedValue")
	private BigDecimal pntQntVal = null;

	@JsonAlias("pymDcmTypNam")
	@JsonProperty("nameTypeGroupReceipt")
	private String pymDcmTypNam = null;

	@JsonAlias("pymDcmTypVal")
	@JsonProperty("paymentDocumentTypeValue")
	private String pymDcmTypVal = null;

	@JsonAlias("pymDcmVal")
	@JsonProperty("paymentThirdPersonDocumentValue")
	private String pymDcmVal = null;

	@JsonAlias("pymExpDat")
	@JsonProperty("paymentExpirationDate")
	private Long pymExpDat = null;

	@JsonAlias("pymOrdVal")
	@JsonProperty("paymentOrderValue")
	private BigDecimal pymOrdVal = null;

	@JsonAlias("pyrCpeNam")
	@JsonProperty("fullNamePayer")
	private String pyrCpeNam = null;

	@JsonAlias("pyrThpAcvVal")
	@JsonProperty("thirdPartyPayerActivity")
	private BigDecimal pyrThpAcvVal = null;

	@JsonAlias("pyrThpDcmTypNam")
	@JsonProperty("nameTypePayingDocument")
	private String pyrThpDcmTypNam = null;

	@JsonAlias("pyrThpDcmTypVal")
	@JsonProperty("typePayingDocument")
	private String pyrThpDcmTypVal = null;

	@JsonAlias("pyrThpDcmVal")
	@JsonProperty("payingDocument")
	private String pyrThpDcmVal = null;

	@JsonAlias("rcpAmn")
	@JsonProperty("receiptAmount")
	private BigDecimal rcpAmn = null;

	@JsonAlias("cmsAmn")
	@JsonProperty("comisionAmount")
	private BigDecimal cmsAmn = new BigDecimal(0);

	@JsonAlias("rcpEfcDat")
	@JsonProperty("receiptEffectiveDate")
	private Long rcpEfcDat = null;

	@JsonAlias("rcpExpDat")
	@JsonProperty("receiptExpirationDate")
	private Long rcpExpDat = null;

	@JsonAlias("rcpFrsAxlVal")
	@JsonProperty("firstAuxiliaryFieldReceipt")
	private String rcpFrsAxlVal = null;

	@JsonAlias("rcpScnAxlVal")
	@JsonProperty("secondAuxiliaryFieldReceipt")
	private String rcpScnAxlVal = null;

	@JsonAlias("rcpStsNam")
	@JsonProperty("receiptSituationName")
	private String rcpStsNam = null;

	@JsonAlias("rcpStsTypVal")
	@JsonProperty("receiptStatusTypeValue")
	private String rcpStsTypVal = null;

	@JsonAlias("rcpVal")
	@JsonProperty("receiptValue")
	private BigDecimal rcpVal = null;

	@JsonAlias("reaCloDat")
	@JsonProperty("auxiliaryDate")
	private Long reaCloDat = null;

	@JsonAlias("rmtDat")
	@JsonProperty("remittanceDate")
	private Long rmtDat = null;

	@JsonAlias("rmtTypNam")
	@JsonProperty("remittanceTypeName")
	private String rmtTypNam = null;

	@JsonAlias("rmtTypVal")
	@JsonProperty("remittanceTypeValue")
	private String rmtTypVal = null;

	@JsonAlias("scnTsyCasNam")
	@JsonProperty("nameCauseSecondaryTreasury")
	private String scnTsyCasNam = null;

	@JsonAlias("scnTsyCasVal")
	@JsonProperty("causeSecondaryTreasury")
	private String scnTsyCasVal = null;

	@JsonAlias("smlVal")
	@JsonProperty("simulateValue")
	private BigDecimal smlVal = null;

	@JsonAlias("smnVal")
	@JsonProperty("quickQuotation")
	private String smnVal = null;

	@JsonAlias("stsDat")
	@JsonProperty("statusDate")
	private Long stsDat = null;

	@JsonAlias("thrLvlVal")
	@JsonProperty("commercial")
	private BigDecimal thrLvlVal = null;

	@JsonAlias("tnsBlcVal")
	@JsonProperty("transactionBlockValue")
	private BigDecimal tnsBlcVal = null;

	@JsonAlias("tsyCasNam")
	@JsonProperty("treasuryReasonName")
	private String tsyCasNam = null;

	@JsonAlias("tsyCasVal")
	@JsonProperty("treasuryCauseValue")
	private String tsyCasVal = null;

	@JsonAlias("valDat")
	@JsonProperty("valueDate")
	private Long valDat = null;

	@JsonAlias("rcpPayDate")
	@JsonProperty("receiptPaymentDate")
	private Long rcpPayDate = null;

	public Long getAcgDat() {
		return acgDat;
	}

	public void setAcgDat(Long acgDat) {
		this.acgDat = acgDat;
	}

	public String getAgnCpeNam() {
		return agnCpeNam;
	}

	public void setAgnCpeNam(String agnCpeNam) {
		this.agnCpeNam = agnCpeNam;
	}

	public BigDecimal getAgnVal() {
		return agnVal;
	}

	public void setAgnVal(BigDecimal agnVal) {
		this.agnVal = agnVal;
	}

	public BigDecimal getAplVal() {
		return aplVal;
	}

	public void setAplVal(BigDecimal aplVal) {
		this.aplVal = aplVal;
	}

	public String getCinTypNam() {
		return cinTypNam;
	}

	public void setCinTypNam(String cinTypNam) {
		this.cinTypNam = cinTypNam;
	}

	public String getCinTypVal() {
		return cinTypVal;
	}

	public void setCinTypVal(String cinTypVal) {
		this.cinTypVal = cinTypVal;
	}

	public BigDecimal getCloCmpVal() {
		return cloCmpVal;
	}

	public void setCloCmpVal(BigDecimal cloCmpVal) {
		this.cloCmpVal = cloCmpVal;
	}

	public String getCloTypNam() {
		return cloTypNam;
	}

	public void setCloTypNam(String cloTypNam) {
		this.cloTypNam = cloTypNam;
	}

	public String getCloTypVal() {
		return cloTypVal;
	}

	public void setCloTypVal(String cloTypVal) {
		this.cloTypVal = cloTypVal;
	}

	public BigDecimal getCmpVal() {
		return cmpVal;
	}

	public void setCmpVal(BigDecimal cmpVal) {
		this.cmpVal = cmpVal;
	}

	public String getCmsDnt() {
		return cmsDnt;
	}

	public void setCmsDnt(String cmsDnt) {
		this.cmsDnt = cmsDnt;
	}

	public String getCrnNam() {
		return crnNam;
	}

	public void setCrnNam(String crnNam) {
		this.crnNam = crnNam;
	}

	public BigDecimal getCrnVal() {
		return crnVal;
	}

	public void setCrnVal(BigDecimal crnVal) {
		this.crnVal = crnVal;
	}

	public BigDecimal getExrVal() {
		return exrVal;
	}

	public void setExrVal(BigDecimal exrVal) {
		this.exrVal = exrVal;
	}

	public BigDecimal getLobVal() {
		return lobVal;
	}

	public void setLobVal(BigDecimal lobVal) {
		this.lobVal = lobVal;
	}

	public String getMnrCpeNam() {
		return mnrCpeNam;
	}

	public void setMnrCpeNam(String mnrCpeNam) {
		this.mnrCpeNam = mnrCpeNam;
	}

	public String getMnrTypNam() {
		return mnrTypNam;
	}

	public void setMnrTypNam(String mnrTypNam) {
		this.mnrTypNam = mnrTypNam;
	}

	public String getMnrTypVal() {
		return mnrTypVal;
	}

	public void setMnrTypVal(String mnrTypVal) {
		this.mnrTypVal = mnrTypVal;
	}

	public String getMnrVal() {
		return mnrVal;
	}

	public void setMnrVal(String mnrVal) {
		this.mnrVal = mnrVal;
	}

	public BigDecimal getMvmVal() {
		return mvmVal;
	}

	public void setMvmVal(BigDecimal mvmVal) {
		this.mvmVal = mvmVal;
	}

	public String getNtcVal() {
		return ntcVal;
	}

	public void setNtcVal(String ntcVal) {
		this.ntcVal = ntcVal;
	}

	public String getOvrVal() {
		return ovrVal;
	}

	public void setOvrVal(String ovrVal) {
		this.ovrVal = ovrVal;
	}

	public String getPlyVal() {
		return plyVal;
	}

	public void setPlyVal(String plyVal) {
		this.plyVal = plyVal;
	}

	public String getPmrSlc() {
		return pmrSlc;
	}

	public void setPmrSlc(String pmrSlc) {
		this.pmrSlc = pmrSlc;
	}

	public BigDecimal getPmsVal() {
		return pmsVal;
	}

	public void setPmsVal(BigDecimal pmsVal) {
		this.pmsVal = pmsVal;
	}

	public BigDecimal getPntQntVal() {
		return pntQntVal;
	}

	public void setPntQntVal(BigDecimal pntQntVal) {
		this.pntQntVal = pntQntVal;
	}

	public String getPymDcmTypNam() {
		return pymDcmTypNam;
	}

	public void setPymDcmTypNam(String pymDcmTypNam) {
		this.pymDcmTypNam = pymDcmTypNam;
	}

	public String getPymDcmTypVal() {
		return pymDcmTypVal;
	}

	public void setPymDcmTypVal(String pymDcmTypVal) {
		this.pymDcmTypVal = pymDcmTypVal;
	}

	public String getPymDcmVal() {
		return pymDcmVal;
	}

	public void setPymDcmVal(String pymDcmVal) {
		this.pymDcmVal = pymDcmVal;
	}

	public Long getPymExpDat() {
		return pymExpDat;
	}

	public void setPymExpDat(Long pymExpDat) {
		this.pymExpDat = pymExpDat;
	}

	public BigDecimal getPymOrdVal() {
		return pymOrdVal;
	}

	public void setPymOrdVal(BigDecimal pymOrdVal) {
		this.pymOrdVal = pymOrdVal;
	}

	public String getPyrCpeNam() {
		return pyrCpeNam;
	}

	public void setPyrCpeNam(String pyrCpeNam) {
		this.pyrCpeNam = pyrCpeNam;
	}

	public BigDecimal getPyrThpAcvVal() {
		return pyrThpAcvVal;
	}

	public void setPyrThpAcvVal(BigDecimal pyrThpAcvVal) {
		this.pyrThpAcvVal = pyrThpAcvVal;
	}

	public String getPyrThpDcmTypNam() {
		return pyrThpDcmTypNam;
	}

	public void setPyrThpDcmTypNam(String pyrThpDcmTypNam) {
		this.pyrThpDcmTypNam = pyrThpDcmTypNam;
	}

	public String getPyrThpDcmTypVal() {
		return pyrThpDcmTypVal;
	}

	public void setPyrThpDcmTypVal(String pyrThpDcmTypVal) {
		this.pyrThpDcmTypVal = pyrThpDcmTypVal;
	}

	public String getPyrThpDcmVal() {
		return pyrThpDcmVal;
	}

	public void setPyrThpDcmVal(String pyrThpDcmVal) {
		this.pyrThpDcmVal = pyrThpDcmVal;
	}

	public BigDecimal getRcpAmn() {
		return rcpAmn;
	}

	public void setRcpAmn(BigDecimal rcpAmn) {
		this.rcpAmn = rcpAmn;
	}

	public BigDecimal getCmsAmn() {
		return cmsAmn;
	}

	public void setCmsAmn(BigDecimal cmsAmn) {
		this.cmsAmn = cmsAmn;
	}

	public Long getRcpEfcDat() {
		return rcpEfcDat;
	}

	public void setRcpEfcDat(Long rcpEfcDat) {
		this.rcpEfcDat = rcpEfcDat;
	}

	public Long getRcpExpDat() {
		return rcpExpDat;
	}

	public void setRcpExpDat(Long rcpExpDat) {
		this.rcpExpDat = rcpExpDat;
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

	public String getRcpStsNam() {
		return rcpStsNam;
	}

	public void setRcpStsNam(String rcpStsNam) {
		this.rcpStsNam = rcpStsNam;
	}

	public String getRcpStsTypVal() {
		return rcpStsTypVal;
	}

	public void setRcpStsTypVal(String rcpStsTypVal) {
		this.rcpStsTypVal = rcpStsTypVal;
	}

	public BigDecimal getRcpVal() {
		return rcpVal;
	}

	public void setRcpVal(BigDecimal rcpVal) {
		this.rcpVal = rcpVal;
	}

	public Long getReaCloDat() {
		return reaCloDat;
	}

	public void setReaCloDat(Long reaCloDat) {
		this.reaCloDat = reaCloDat;
	}

	public Long getRmtDat() {
		return rmtDat;
	}

	public void setRmtDat(Long rmtDat) {
		this.rmtDat = rmtDat;
	}

	public String getRmtTypNam() {
		return rmtTypNam;
	}

	public void setRmtTypNam(String rmtTypNam) {
		this.rmtTypNam = rmtTypNam;
	}

	public String getRmtTypVal() {
		return rmtTypVal;
	}

	public void setRmtTypVal(String rmtTypVal) {
		this.rmtTypVal = rmtTypVal;
	}

	public String getScnTsyCasNam() {
		return scnTsyCasNam;
	}

	public void setScnTsyCasNam(String scnTsyCasNam) {
		this.scnTsyCasNam = scnTsyCasNam;
	}

	public String getScnTsyCasVal() {
		return scnTsyCasVal;
	}

	public void setScnTsyCasVal(String scnTsyCasVal) {
		this.scnTsyCasVal = scnTsyCasVal;
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

	public Long getStsDat() {
		return stsDat;
	}

	public void setStsDat(Long stsDat) {
		this.stsDat = stsDat;
	}

	public BigDecimal getThrLvlVal() {
		return thrLvlVal;
	}

	public void setThrLvlVal(BigDecimal thrLvlVal) {
		this.thrLvlVal = thrLvlVal;
	}

	public BigDecimal getTnsBlcVal() {
		return tnsBlcVal;
	}

	public void setTnsBlcVal(BigDecimal tnsBlcVal) {
		this.tnsBlcVal = tnsBlcVal;
	}

	public String getTsyCasNam() {
		return tsyCasNam;
	}

	public void setTsyCasNam(String tsyCasNam) {
		this.tsyCasNam = tsyCasNam;
	}

	public String getTsyCasVal() {
		return tsyCasVal;
	}

	public void setTsyCasVal(String tsyCasVal) {
		this.tsyCasVal = tsyCasVal;
	}

	public Long getValDat() {
		return valDat;
	}

	public void setValDat(Long valDat) {
		this.valDat = valDat;
	}

	public Long getRcpPayDate() {
		return rcpPayDate;
	}

	public void setRcpPayDate(Long rcpPayDate) {
		this.rcpPayDate = rcpPayDate;
	}

}
