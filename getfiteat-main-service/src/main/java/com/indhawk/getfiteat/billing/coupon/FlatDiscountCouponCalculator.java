package com.indhawk.getfiteat.billing.coupon;

import java.util.Date;

public class FlatDiscountCouponCalculator implements CouponCalculator {

	@Override
	public double calculate(Coupon coupon, double payable) {
		if (isCouponExpired(coupon))
			return 0.00;
		if (coupon.getMinAmount() >= payable)
			return 0.00;
		
		double discount = coupon.getDiscount();
		return discount;
	}
	
	
}
