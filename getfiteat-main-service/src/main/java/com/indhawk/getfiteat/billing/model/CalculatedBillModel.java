package com.indhawk.getfiteat.billing.model;

import java.math.BigDecimal;
import java.util.List;

public class CalculatedBillModel {
	
	private List<ItemModel> itemsList;
	
	private BigDecimal totalPrice;
	
	private BigDecimal deliveryCharge;
	
	private BigDecimal gst;
	
	private BigDecimal cgst;
	
	private BigDecimal sgst;
	
	private BigDecimal couponDiscount;
	
	private BigDecimal payable;

	public CalculatedBillModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<ItemModel> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<ItemModel> itemsList) {
		this.itemsList = itemsList;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BigDecimal getDeliveryCharge() {
		return deliveryCharge;
	}

	public void setDeliveryCharge(BigDecimal deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}

	public BigDecimal getGst() {
		return gst;
	}

	public void setGst(BigDecimal gst) {
		this.gst = gst;
	}

	public BigDecimal getCgst() {
		return cgst;
	}

	public void setCgst(BigDecimal cgst) {
		this.cgst = cgst;
	}

	public BigDecimal getSgst() {
		return sgst;
	}

	public void setSgst(BigDecimal sgst) {
		this.sgst = sgst;
	}

	public BigDecimal getCouponDiscount() {
		return couponDiscount;
	}

	public void setCouponDiscount(BigDecimal couponDiscount) {
		this.couponDiscount = couponDiscount;
	}

	public BigDecimal getPayable() {
		return payable;
	}

	public void setPayable(BigDecimal payable) {
		this.payable = payable;
	}

	@Override
	public String toString() {
		return "CalculatedBillModel [itemsList=" + itemsList + ", totalPrice=" + totalPrice + ", deliveryCharge="
				+ deliveryCharge + ", gst=" + gst + ", cgst=" + cgst + ", sgst=" + sgst + ", couponDiscount="
				+ couponDiscount + ", payable=" + payable + "]";
	}
	

}
