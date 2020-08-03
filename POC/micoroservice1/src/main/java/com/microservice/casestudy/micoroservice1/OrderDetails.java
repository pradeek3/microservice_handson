package com.microservice.casestudy.micoroservice1;





public class OrderDetails {
	

	private int id;
	

	private String orderName;
	
	
	private String transactionToken;
	

	private String serviceToken;
	

	private String userToken;

public OrderDetails() {
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getTransactionToken() {
		return transactionToken;
	}

	public void setTransactionToken(String transactionToken) {
		this.transactionToken = transactionToken;
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

	public OrderDetails(int id, String orderName, String transactionToken, String serviceToken, String userToken) {
		super();
		this.id = id;
		this.orderName = orderName;
		this.transactionToken = transactionToken;
		this.serviceToken = serviceToken;
		this.userToken = userToken;
	}
	
	
	

}
