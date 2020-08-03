package com.reskill.microservice.reskillmicroserviceorder;


import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends 
		JpaRepository<OrderDetails, Long>{
}
