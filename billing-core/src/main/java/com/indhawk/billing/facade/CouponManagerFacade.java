package com.indhawk.billing.facade;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.indhawk.billing.coupon.Coupon;
import com.indhawk.billing.coupon.CouponManager;
import com.indhawk.billing.coupon.DiscountType;
import com.indhawk.billing.request.CouponRequest;
import com.indhawk.billing.service.CouponManagerService;

@Component
public class CouponManagerFacade {
	
	@Autowired
	private CouponManagerService couponManagerService;
	
	@Autowired
	private CouponManager couponManager;
	
	public Coupon createCoupon(CouponRequest couponRequest) {
		Coupon coupon = new Coupon();
		BeanUtils.copyProperties(couponRequest, coupon);
		DiscountType discountType = DiscountType.valueOf(couponRequest.getDiscountType().toUpperCase());
		coupon.setDiscountType(discountType);
		return couponManagerService.createCoupon(coupon);
	}
	
	public boolean isValidCoupon(String coupon) {
		return couponManagerService.isValidCoupon(coupon);
	}
	
	public void initalizeCouponCache() {
		couponManager.init();
	}
	

}
