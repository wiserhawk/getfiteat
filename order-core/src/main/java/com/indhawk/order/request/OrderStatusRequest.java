package com.indhawk.order.request;

public class OrderStatusRequest {
	
	private String orderId;
	
	private String status;

	public OrderStatusRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "OrderStatusRequest [orderId=" + orderId + ", status=" + status + "]";
	}
	

}
