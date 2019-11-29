package com.indhawk.order.validator;

import org.springframework.stereotype.Component;

import com.indhawk.order.PaymentMode;

@Component
public class PaymentModeRequestValidator {
	
	public boolean validate(String paymentMode) {
		for (PaymentMode mode : PaymentMode.values()) {
			if (mode.getPaymentType().equalsIgnoreCase(paymentMode)) {
				return true;
			}
		}
		return false;
	}

}
