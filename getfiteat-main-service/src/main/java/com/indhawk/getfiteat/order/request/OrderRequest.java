package com.indhawk.getfiteat.order.request;

import java.util.Date;

public class OrderRequest {
	
	private String transactionId;
	
	private Date orderDate;
	
	private Bill bill;
	
	private String userId;
	
	private String email;
	
	private String customerName;
	
	private String contactNumber;
	
	private String billTo;
	
	private String shipTo;
	
	private String paymentMode;
	
	public OrderRequest() {
		super();
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill invoice) {
		this.bill = invoice;
	}

	public String getBillTo() {
		return billTo;
	}

	public void setBillTo(String billTo) {
		this.billTo = billTo;
	}

	public String getShipTo() {
		return shipTo;
	}

	public void setShipTo(String shipTo) {
		this.shipTo = shipTo;
	}
	
	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "OrderRequest [transactionId=" + transactionId + ", orderDate=" + orderDate + ", bill=" + bill
				+ ", userId=" + userId + ", email=" + email + ", customerName=" + customerName + ", contactNumber="
				+ contactNumber + ", billTo=" + billTo + ", shipTo=" + shipTo + ", paymentMode=" + paymentMode + "]";
	}

}
