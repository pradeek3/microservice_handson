package com.microservice.casestudy.micoroservice1;

public class GenerateToken {
	
	private String transctionToken;
	private String  serviceToken;
	private String userToken;
	
	
	public GenerateToken()
	{
		
	}
	
	public String getTransctionToken() {
		return transctionToken;
	}
	public void setTransctionToken(String transctionToken) {
		this.transctionToken = transctionToken;
	}
	public String getServiceToken() {
		return serviceToken;
	}
	public void setServiceToken(String serviceToken) {
		this.serviceToken = serviceToken;
	}
	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	public GenerateToken(String transctionToken, String serviceToken, String userToken) {
		super();
		this.transctionToken = transctionToken;
		this.serviceToken = serviceToken;
		this.userToken = userToken;
	}
	
	

}
