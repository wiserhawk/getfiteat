package com.indhawk.getfiteat.order.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.indhawk.getfiteat.order.enums.OrderStatus;
import com.indhawk.getfiteat.order.request.OrderStatusRequest;

@Component
public class OrderStatusRequestValidator {
	
	public boolean validate(OrderStatusRequest request) {
		if (request == null)
			return false;
		if (StringUtils.isEmpty(request.getOrderId())) 
			return false;
		if (StringUtils.isEmpty(request.getStatus())) 
			return false;
		for (OrderStatus status: OrderStatus.values()) {
			if (status.name().equalsIgnoreCase(request.getStatus()))
				return true;
		}
		return false;
	}

}
