package com.indhawk.order.response;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Invoice {
	
	private String invoiceNumber;
	
	private Date invoiceDate;
	
	private String customerName;
	
	private String contactNumber;
	
	private String pan;
	
	private String cin;
	
	private String coupon;
	
	private List<Item> itemsList;
	
	private BigDecimal totalPrice;
	
	private BigDecimal gst;
	
	private BigDecimal cgst;
	
	private BigDecimal sgst;
	
	private BigDecimal couponDiscount;
	
	private BigDecimal payable;

	public Invoice() {
		super();
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
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

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
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

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
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
		return "Invoice [invoiceNumber=" + invoiceNumber + ", invoiceDate=" + invoiceDate + ", customerName="
				+ customerName + ", contactNumber=" + contactNumber + ", pan=" + pan + ", cin=" + cin + ", coupon="
				+ coupon + ", itemsList=" + itemsList + ", totalPrice=" + totalPrice + ", gst=" + gst + ", cgst=" + cgst
				+ ", sgst=" + sgst + ", couponDiscount=" + couponDiscount + ", payable=" + payable + "]";
	}
	
	
}
