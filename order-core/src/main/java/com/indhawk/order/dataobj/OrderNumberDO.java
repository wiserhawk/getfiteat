package com.indhawk.order.dataobj;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="OrderNumbers")
public class OrderNumberDO {

	@Id
	private long orderNumber;
	
	private boolean isOrderNumberUsed;
	
	public OrderNumberDO() {
		super();
	}
	
	public OrderNumberDO(long orderNumber, boolean isOrderNumberUsed) {
		super();
		this.orderNumber = orderNumber;
		this.isOrderNumberUsed = isOrderNumberUsed;
	}

	public long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public boolean isOrderNumberUsed() {
		return isOrderNumberUsed;
	}

	public void setOrderNumberUsed(boolean isOrderNumberUsed) {
		this.isOrderNumberUsed = isOrderNumberUsed;
	}

	@Override
	public String toString() {
		return "OrderNumberDO [orderNumber=" + orderNumber + ", isOrderNumberUsed=" + isOrderNumberUsed + "]";
	}
	
	
	
}

