package com.indhawk.getfiteat.payment.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.indhawk.getfiteat.payment.model.PaymentDetail;

public class PaymentUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentUtil.class);
	
	private static final boolean PAYMENT_TEST_MODE = true;
	
	private static final String PAYMENT_TEST_KEY = "gtKFFx"; 

	private static final String PAYMENT_TEST_SALT = "eCwWELxi";
	
	private static final String PAYMENT_LIVE_KEY = "QsdZAtJV";

	private static final String PAYMENT_LIVE_SALT = "fuqArMEbIj";
		
	private static final String sUrl = "http://localhost:9900/gfe-main/payment/payumoney/payment-response";

	private static final String fUrl = "http://localhost:9900/gfe-main/payment/payumoney/payment-response";
	
	private static final String TXN_PREFIX = "TXN";
	

	public static PaymentDetail populatePaymentDetail(PaymentDetail paymentDetail) {
		String hashString = "";
		Random rand = new Random();
		String randomId = Integer.toString(rand.nextInt()) + (System.currentTimeMillis() / 1000L);
		String txnId = TXN_PREFIX + hashCal("SHA-256", randomId).substring(0, 12);
		paymentDetail.setTxnId(txnId);
		String hash = "";
		// String otherPostParamSeq =
		// "phone|surl|furl|lastname|curl|address1|address2|city|state|country|zipcode|pg";
		String hashSequence = "key|txnid|amount|productinfo|firstname|email|||||||||||";
		// Add Salt accordingly
		if (PAYMENT_TEST_MODE)
			hashString = hashSequence.concat(PAYMENT_TEST_SALT);
		else 
			hashString = hashSequence.concat(PAYMENT_LIVE_SALT);
		// Add Key accordingly
		if (PAYMENT_TEST_MODE)
			hashString = hashString.replace("key", PAYMENT_TEST_KEY);
		else 
			hashString = hashString.replace("key", PAYMENT_LIVE_KEY);
		
		hashString = hashString.replace("txnid", txnId);
		hashString = hashString.replace("amount", paymentDetail.getAmount());
		hashString = hashString.replace("productinfo", paymentDetail.getProductInfo().toString());
		hashString = hashString.replace("firstname", paymentDetail.getName());
		hashString = hashString.replace("email", paymentDetail.getEmail());

		hash = hashCal("SHA-512", hashString);
		paymentDetail.setHash(hash);
		paymentDetail.setfUrl(fUrl);
		paymentDetail.setsUrl(sUrl);
		// Add Key accordingly
		if (PAYMENT_TEST_MODE) 
			paymentDetail.setKey(PAYMENT_TEST_KEY);
		else 
			paymentDetail.setKey(PAYMENT_LIVE_KEY);
		
		LOGGER.debug("PaymentDetail = {}", paymentDetail);
		
		return paymentDetail;
	}

	public static String hashCal(String type, String str) {
		byte[] hashseq = str.getBytes();
		StringBuffer hexString = new StringBuffer();
		try {
			MessageDigest algorithm = MessageDigest.getInstance(type);
			algorithm.reset();
			algorithm.update(hashseq);
			byte messageDigest[] = algorithm.digest();
			for (int i = 0; i < messageDigest.length; i++) {
				String hex = Integer.toHexString(0xFF & messageDigest[i]);
				if (hex.length() == 1) {
					hexString.append("0");
				}
				hexString.append(hex);
			}

		} catch (NoSuchAlgorithmException nsae) {
		}
		return hexString.toString();
	}

}
