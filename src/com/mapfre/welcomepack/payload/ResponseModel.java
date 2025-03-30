package com.mapfre.welcomepack.payload;

import java.util.List;

public class ResponseModel {
	
	private List<String> encabezados;
    private List<List<String>> rows;
	
    public List<String> getEncabezados() {
		return encabezados;
	}
	public void setEncabezados(List<String> encabezados) {
		this.encabezados = encabezados;
	}
	public List<List<String>> getRows() {
		return rows;
	}
	public void setRows(List<List<String>> rows) {
		this.rows = rows;
	}
    
}
