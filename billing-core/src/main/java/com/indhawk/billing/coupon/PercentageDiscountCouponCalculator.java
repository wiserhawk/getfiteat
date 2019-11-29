package com.indhawk.billing.coupon;

public class PercentageDiscountCouponCalculator implements CouponCalculator {

	@Override
	public double calculate(Coupon coupon, double payable) {
		if (isCouponExpired(coupon))
			return 0.00;
		if (coupon.getMinAmount() >= payable)
			return 0.00;
		
		double discount = (payable * coupon.getDiscount()) / 100;
		return discount;
	}

}
