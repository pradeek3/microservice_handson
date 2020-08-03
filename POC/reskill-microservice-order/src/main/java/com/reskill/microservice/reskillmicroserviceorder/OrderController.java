package com.reskill.microservice.reskillmicroserviceorder;
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired
	OrderDetailsRepository repository;
	
	@GetMapping("/getOrderDetails")
    public List<OrderDetails> getOrderDetails()
    {
		List<OrderDetails> orderDetails=repository.findAll();
		return orderDetails;
    }
	
	@PostMapping("/addOrderDetails")
    public TransctionDetails addOrderDetails(@RequestBody OrderDetails orderDetails)
    {
		try
		{
		TransctionDetails transctionDetails=new TransctionDetails();
		OrderDetails orderDetails1=repository.save(orderDetails);
		transctionDetails.setMessage("OrderReceivedSuccessFully");
		transctionDetails.setStatusCode("0");
		transctionDetails.setTransctionId(orderDetails1.getOrderNumber());
		return transctionDetails;
		}
		catch(Exception e)
		{
			TransctionDetails transctionDetails=new TransctionDetails();
			transctionDetails.setMessage("failed");
			transctionDetails.setStatusCode("101");
			transctionDetails.setTransctionId("0000");
			return transctionDetails;	
		}
		
    }
	

}
