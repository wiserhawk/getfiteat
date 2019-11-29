package com.indhawk.getfiteat.order.request;

import java.util.Date;
import java.util.List;

public class Bill {
	
	private Date billDate;
	
	private String customerName;
	
	private String contactNumber;
	
	private String coupon;
	
	private List<Item> itemsList;
	
	private float totalPrice;
	
	private float deliveryCharge;
	
	private float gst;
	
	private float cgst;
	
	private float sgst;
	
	private float couponDiscount;
	
	private float payable;

	public Bill() {
		super();
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
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

	public String getCoupon() {
		return coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public List<Item> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<Item> itemsList) {
		this.itemsList = itemsList;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public float getDeliveryCharge() {
		return deliveryCharge;
	}

	public void setDeliveryCharge(float deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}

	public float getGst() {
		return gst;
	}

	public void setGst(float gst) {
		this.gst = gst;
	}

	public float getCgst() {
		return cgst;
	}

	public void setCgst(float cgst) {
		this.cgst = cgst;
	}

	public float getSgst() {
		return sgst;
	}

	public void setSgst(float sgst) {
		this.sgst = sgst;
	}

	public float getCouponDiscount() {
		return couponDiscount;
	}

	public void setCouponDiscount(float couponDiscount) {
		this.couponDiscount = couponDiscount;
	}

	public float getPayable() {
		return payable;
	}

	public void setPayable(float payable) {
		this.payable = payable;
	}

	@Override
	public String toString() {
		return "Bill [billDate=" + billDate + ", customerName=" + customerName + ", contactNumber=" + contactNumber
				+ ", coupon=" + coupon + ", itemsList=" + itemsList + ", totalPrice=" + totalPrice
				+ ", deliveryCharges=" + deliveryCharge + ", gst=" + gst + ", cgst=" + cgst + ", sgst=" + sgst
				+ ", couponDiscount=" + couponDiscount + ", payable=" + payable + "]";
	}

	

}
