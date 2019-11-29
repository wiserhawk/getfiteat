package com.indhawk.getfiteat.payment.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.indhawk.getfiteat.payment.model.PaymentCallback;
import com.indhawk.getfiteat.payment.model.PaymentDetail;
import com.indhawk.getfiteat.payment.response.PaymentDetailResponse;
import com.indhawk.getfiteat.payment.service.PaymentService;
import com.indhawk.getfiteat.payment.util.PaymentMode;

@RestController
@RequestMapping("gfe-main/payment/payumoney/")
public class PayUMoneyController {

	@Autowired
	private PaymentService paymentService;
	
	@Value("${payment.success.url}")
	private String paymentSuccessUrl;
	
	@Value("${payment.failure.url}")
	private String paymentFailureUrl;
	
	private static final String SUCCESS = "SUCCESS";
	
	private static final String FAILED = "FAILED";

	@CrossOrigin(origins="*")
	@PostMapping(path = "payment-details")
	public @ResponseBody PaymentDetailResponse proceedPayment(@RequestBody PaymentDetail paymentDetail) {
		return paymentService.proceedPayment(paymentDetail);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(path = "payment-response", method = RequestMethod.POST)
	public @ResponseBody void paymentCallback(@RequestParam String mihpayid, @RequestParam String status,
			@RequestParam PaymentMode mode, @RequestParam String txnid, @RequestParam String hash,
			HttpServletResponse response) {
		PaymentCallback paymentCallback = new PaymentCallback();
		paymentCallback.setMihpayid(mihpayid);
		paymentCallback.setTxnid(txnid);
		paymentCallback.setMode(mode);
		paymentCallback.setHash(hash);
		paymentCallback.setStatus(status);
		String tnxResponse = paymentService.payuCallback(paymentCallback);
		try {
			if (SUCCESS.equals(tnxResponse))
				response.sendRedirect(paymentSuccessUrl);
			else
				response.sendRedirect(paymentFailureUrl);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
