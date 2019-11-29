package com.indhawk.getfiteat.order.response;

import java.util.Date;

import com.indhawk.getfiteat.order.enums.OrderStatus;
import com.indhawk.getfiteat.order.enums.PaymentMode;
import com.indhawk.getfiteat.order.model.InvoiceModel;

public class OrderResponse {
	
	private String orderId;
	
	private String orderDate;
	
	private String transactionId;
	
	private InvoiceModel invoice;
	
	private String userId;
	
	private String email;
	
	private String customerName;
	
	private String contactNumber;
	
	private String billTo;
	
	private String shipTo;
	
	private PaymentMode paymentMode;
	
	private  OrderStatus orderStatus;
	
	private String vendorId;
	
	public OrderResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public InvoiceModel getInvoice() {
		return invoice;
	}

	public void setInvoice(InvoiceModel invoice) {
		this.invoice = invoice;
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

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	@Override
	public String toString() {
		return "OrderResponse [orderId=" + orderId + ", orderDate=" + orderDate + ", transactionId=" + transactionId
				+ ", invoice=" + invoice + ", userId=" + userId + ", email=" + email + ", customerName=" + customerName
				+ ", contactNumber=" + contactNumber + ", billTo=" + billTo + ", shipTo=" + shipTo + ", paymentMode="
				+ paymentMode + ", orderStatus=" + orderStatus + ", vendorId=" + vendorId + "]";
	}

	
	

}
