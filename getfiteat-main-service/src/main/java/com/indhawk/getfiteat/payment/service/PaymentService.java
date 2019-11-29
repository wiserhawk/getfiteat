package com.indhawk.getfiteat.payment.service;

import com.indhawk.getfiteat.payment.model.PaymentCallback;
import com.indhawk.getfiteat.payment.model.PaymentDetail;
import com.indhawk.getfiteat.payment.response.PaymentDetailResponse;

public interface PaymentService {
	
	 public PaymentDetailResponse proceedPayment(PaymentDetail paymentDetail);
	 
	 public String payuCallback(PaymentCallback paymentResponse);

}
