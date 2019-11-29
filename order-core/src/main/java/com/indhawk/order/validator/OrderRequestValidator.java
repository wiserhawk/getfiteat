package com.indhawk.order.validator;

import org.springframework.stereotype.Component;

import com.indhawk.order.request.OrderRequest;

@Component
public class OrderRequestValidator {
	
	public boolean validate(OrderRequest request) {
		return true;
	}

}
