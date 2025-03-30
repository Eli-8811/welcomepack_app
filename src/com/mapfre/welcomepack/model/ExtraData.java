package com.mapfre.welcomepack.model;

public class ExtraData {

	private String productoComercial;/////////////COLUMNA 12
	private String docPoliza;/////////////////////COLUMNA 13
	private String docRecibo;/////////////////////COLUMNA 14
	private String docCondicionesGenerales;///////COLUMNA 15
	private char sector;//////////////////////////COLUMNA 16
	
	private ExtraDataParams extraDataParams;
	
	public String getProductoComercial() {
		return productoComercial;
	}
	public void setProductoComercial(String productoComercial) {
		this.productoComercial = productoComercial;
	}
	public String getDocPoliza() {
		return docPoliza;
	}
	public void setDocPoliza(String docPoliza) {
		this.docPoliza = docPoliza;
	}
	public String getDocRecibo() {
		return docRecibo;
	}
	public void setDocRecibo(String docRecibo) {
		this.docRecibo = docRecibo;
	}
	public String getDocCondicionesGenerales() {
		return docCondicionesGenerales;
	}
	public void setDocCondicionesGenerales(String docCondicionesGenerales) {
		this.docCondicionesGenerales = docCondicionesGenerales;
	}
	public char getSector() {
		return sector;
	}
	public void setSector(char sector) {
		this.sector = sector;
	}
	public ExtraDataParams getExtraDataParams() {
		return extraDataParams;
	}
	public void setExtraDataParams(ExtraDataParams extraDataParams) {
		this.extraDataParams = extraDataParams;
	}
	
}