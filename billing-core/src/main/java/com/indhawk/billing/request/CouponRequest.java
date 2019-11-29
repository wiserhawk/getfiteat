package com.indhawk.billing.request;

import java.util.Date;

import com.indhawk.billing.coupon.DiscountType;

public class CouponRequest {
	
	private String coupon;
	
	private Date startDate;
	
	private Date expiryDate;
	
	private int minAmount;
	
	private String discountType;
	
	private int discount;

	public CouponRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCoupon() {
		return coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(int minAmount) {
		this.minAmount = minAmount;
	}

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "CouponRequest [coupon=" + coupon + ", startDate=" + startDate + ", expiryDate=" + expiryDate
				+ ", minAmount=" + minAmount + ", discountType=" + discountType + ", discount=" + discount + "]";
	}
	
	

}
