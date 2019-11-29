package com.indhawk.getfiteat.billing.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.indhawk.getfiteat.billing.coupon.DiscountType;
import com.indhawk.getfiteat.billing.request.CouponRequest;

@Component
public class CouponRequestValidator {
	
	public boolean validate(CouponRequest coupon) {
		if (coupon == null)
			throw new RuntimeException("Coupon object cannot be null");
		if (StringUtils.isEmpty(coupon.getCoupon()))
			throw new RuntimeException("Coupon code cannot be null");
		if (coupon.getStartDate() == null)
			throw new RuntimeException("Coupon start date cannot be null");
		if (coupon.getExpiryDate() == null)
			throw new RuntimeException("Coupon expirty date cannot be null");
		if (!DiscountType.isExists(coupon.getDiscountType()))
			throw new RuntimeException("DiscountType must be one of them [ "+ DiscountType.getAllDiscountTypesAsString() + " ]");
		if (coupon.getDiscount() <= 0)
			throw new RuntimeException("Dicount must be greater than 0");
		
		return true;
	}
	

}
