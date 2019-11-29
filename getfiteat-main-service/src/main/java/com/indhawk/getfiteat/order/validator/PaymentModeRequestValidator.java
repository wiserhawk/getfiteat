package com.indhawk.getfiteat.order.validator;

import org.springframework.stereotype.Component;

import com.indhawk.getfiteat.order.enums.PaymentMode;

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
