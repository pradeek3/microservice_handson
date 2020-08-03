package com.reskill.microservice.reskillmicroserviceorder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderDetails {
	
	@Id
	@Column(name="order_Number")
	private String orderNumber;
	
	@Column(name="order_name")
	private String orderName;
	
	@Column(name="transaction_token")
	private String transactionToken;
	
	@Column(name="service_token")
	private String serviceToken;
	
	@Column(name="user_token",length=2000)
	private String userToken;

public OrderDetails() {
		
	}

	public String getOrderNumber() {
	return orderNumber;
}

public void setOrderNumber(String orderNumber) {
	this.orderNumber = orderNumber;
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

	public OrderDetails(String orderNumber, String orderName, String transactionToken, String serviceToken, String userToken) {
		super();
		this.orderNumber = orderNumber;
		this.orderName = orderName;
		this.transactionToken = transactionToken;
		this.serviceToken = serviceToken;
		this.userToken = userToken;
	}
	
	
	

}
