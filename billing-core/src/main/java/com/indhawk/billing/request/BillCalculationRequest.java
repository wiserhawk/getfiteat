package com.indhawk.billing.request;

import java.util.List;

public class BillCalculationRequest {
	
	private List<Item> itemList;
	
	private String coupon;

	public BillCalculationRequest() {
		super();
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public String getCoupon() {
		return coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	@Override
	public String toString() {
		return "BillCalculationRequest [itemList=" + itemList + ", coupon=" + coupon + "]";
	}
	
}
