package com.mapfre.welcomepack.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DocumentumResponse {
	
    @JsonProperty("Status")
    private Integer status;
    
    @JsonProperty("Description")
    private String description;
    
    @JsonProperty("Data")
    private String data;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
    
}
