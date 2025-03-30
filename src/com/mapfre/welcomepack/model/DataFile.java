package com.mapfre.welcomepack.model;

import java.util.List;

import org.apache.commons.csv.CSVRecord;

public class DataFile {

	private List<String> headers;
	private List<CSVRecord> records;
	
	public List<String> getHeaders() {
		return headers;
	}
	public void setHeaders(List<String> headers) {
		this.headers = headers;
	}
	public List<CSVRecord> getRecords() {
		return records;
	}
	public void setRecords(List<CSVRecord> records) {
		this.records = records;
	}
	
}
