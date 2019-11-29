package com.indhawk.getfiteat.order.validator;

import org.springframework.stereotype.Component;

import com.indhawk.getfiteat.order.request.OrderRequest;

@Component
public class OrderRequestValidator {
	
	public boolean validate(OrderRequest request) {
		return true;
	}

}
