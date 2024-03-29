package com.indhawk.getfiteat.payment.model;

import java.util.List;

public class PaymentDetail {

	private String email;
	
	private String name;
	
	private String phone;
	
	private List<ProductInfo> productInfo;
	
	private String amount;
	
	private String txnId;
	
	private String hash;
	
	private String sUrl;
	
	private String fUrl;
	
	private String key;

	public PaymentDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<ProductInfo> getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(List<ProductInfo> productInfo) {
		this.productInfo = productInfo;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getTxnId() {
		return txnId;
	}

	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getsUrl() {
		return sUrl;
	}

	public void setsUrl(String sUrl) {
		this.sUrl = sUrl;
	}

	public String getfUrl() {
		return fUrl;
	}

	public void setfUrl(String fUrl) {
		this.fUrl = fUrl;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "PayUMoneyPaymentDetail [email=" + email + ", name=" + name + ", phone=" + phone + ", productInfo="
				+ productInfo + ", amount=" + amount + ", txnId=" + txnId + ", hash=" + hash + ", sUrl=" + sUrl
				+ ", fUrl=" + fUrl + ", key=" + key + "]";
	}
	
	

}
