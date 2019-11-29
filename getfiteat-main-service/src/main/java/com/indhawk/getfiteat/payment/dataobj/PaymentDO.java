package com.indhawk.getfiteat.payment.dataobj;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.indhawk.getfiteat.payment.util.PaymentMode;
import com.indhawk.getfiteat.payment.util.PaymentStatus;

@Document(collection = "Payments")
public class PaymentDO {

	@Id
	private String id;
	
	private String email;
	
	private String name;
	
	private String phone;
	
	private String productInfo;
	
	private Double amount;
	
	private PaymentStatus paymentStatus;
	
	private Date paymentDate;
	
	private String txnId;
	
	private String mihpayId;
	
	private PaymentMode mode;

	public PaymentDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getTxnId() {
		return txnId;
	}

	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	public String getMihpayId() {
		return mihpayId;
	}

	public void setMihpayId(String mihpayId) {
		this.mihpayId = mihpayId;
	}

	public PaymentMode getMode() {
		return mode;
	}

	public void setMode(PaymentMode mode) {
		this.mode = mode;
	}

	@Override
	public String toString() {
		return "PaymentDO [id=" + id + ", email=" + email + ", name=" + name + ", phone=" + phone + ", productInfo="
				+ productInfo + ", amount=" + amount + ", paymentDate=" + paymentDate + ", txnId=" + txnId
				+ ", mihpayId=" + mihpayId + ", mode=" + mode + "]";
	}
	
	

}
