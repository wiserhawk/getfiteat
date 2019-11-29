package com.indhawk.billing.coupon;

public class CouponCalculatorFactory {


	public static CouponCalculator getCouponCalculator(DiscountType type) {
		if (DiscountType.FLAT == type)
			return new FlatDiscountCouponCalculator();
		else if (DiscountType.PERCENTAGE == type)
			return new PercentageDiscountCouponCalculator();
		
		return null;
	}

}
