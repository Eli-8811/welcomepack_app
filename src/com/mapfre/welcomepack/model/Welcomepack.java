package com.mapfre.welcomepack.model;

public class Welcomepack {

	private String numPoliza;////////////////// COLUMNA 1
	private String nombreContratante;////////// COLUMNA 2
	private String email;////////////////////// COLUMNA 3
	private String telefono;/////////////////// COLUMNA 4
	private String fecEfecPoliza;////////////// COLUMNA 5
	private String fecVctoPoliza;////////////// COLUMNA 6
	private String impPrima;/////////////////// COLUMNA 7
	private ExtraData extraData;

	public Welcomepack(String numPoliza, String nombreContratante, String email, String telefono, String fecEfecPoliza,
			String fecVctoPoliza, String impPrima, ExtraData extraData) {
		
		this.numPoliza = numPoliza;
		this.nombreContratante = nombreContratante;
		this.email = email;
		this.telefono = telefono;
		this.fecEfecPoliza = fecEfecPoliza;
		this.fecVctoPoliza = fecVctoPoliza;
		this.impPrima = impPrima;
		this.extraData = extraData;
	}

	public String getNumPoliza() {
		return numPoliza;
	}

	public void setNumPoliza(String numPoliza) {
		this.numPoliza = numPoliza;
	}

	public String getNombreContratante() {
		return nombreContratante;
	}

	public void setNombreContratante(String nombreContratante) {
		this.nombreContratante = nombreContratante;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFecEfecPoliza() {
		return fecEfecPoliza;
	}

	public void setFecEfecPoliza(String fecEfecPoliza) {
		this.fecEfecPoliza = fecEfecPoliza;
	}

	public String getFecVctoPoliza() {
		return fecVctoPoliza;
	}

	public void setFecVctoPoliza(String fecVctoPoliza) {
		this.fecVctoPoliza = fecVctoPoliza;
	}

	public String getImpPrima() {
		return impPrima;
	}

	public void setImpPrima(String impPrima) {
		this.impPrima = impPrima;
	}

	public ExtraData getExtraData() {
		return extraData;
	}

	public void setExtraData(ExtraData extraData) {
		this.extraData = extraData;
	}

}