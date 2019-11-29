package com.indhawk.getfiteat.billing.coupon;

import java.util.Date;

public interface CouponCalculator {
	
	/**
	 * Calculate discounted amount after applying coupon calculation on payable
	 * amount.
	 * 
	 * @return Discounted amount
	 */
	double calculate(Coupon coupon, double payable);
	
	default boolean isCouponExpired(Coupon coupon) {
		Date startDate = coupon.getStartDate();
		Date expiryDate = coupon.getExpiryDate();
		if (startDate == null || expiryDate == null) 
			return true;
		Date currentDate = new Date();
		if (currentDate.equals(startDate) || currentDate.equals(expiryDate))
			return false;
		if (currentDate.after(startDate) && currentDate.before(expiryDate))
			return false;
		return true;
	}

}
