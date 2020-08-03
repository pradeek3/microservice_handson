package com.reskill.microservice.reskillmicroserviceorder;

public class TransctionDetails {
	private String message;
	private String transctionId;
	private String statusCode;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTransctionId() {
		return transctionId;
	}
	public void setTransctionId(String transctionId) {
		this.transctionId = transctionId;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	

}
