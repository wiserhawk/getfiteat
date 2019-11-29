package com.indhawk.billing.dataobj;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.indhawk.billing.coupon.DiscountType;

@Document(collection="Coupons")
public class CouponDO {

	@Id
	private String coupon;
	
	private Date startDate;
	
	private Date expiryDate;
	
	private int minAmount;
	
	private DiscountType discountType;
	
	private int discount;

	public CouponDO() {
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

	public DiscountType getDiscountType() {
		return discountType;
	}

	public void setDiscountType(DiscountType discountType) {
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
		return "CouponDO [coupon=" + coupon + ", startDate=" + startDate + ", expiryDate=" + expiryDate + ", minAmount="
				+ minAmount + ", discountType=" + discountType + ", discount=" + discount + "]";
	}
}
