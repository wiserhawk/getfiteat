package com.indhawk.billing.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indhawk.billing.coupon.Coupon;
import com.indhawk.billing.coupon.CouponManager;
import com.indhawk.billing.dataobj.CouponDO;
import com.indhawk.billing.repository.CouponRepository;

@Service
public class CouponManagerService {
	
	@Autowired
	private CouponManager couponManager;
	
	@Autowired
	private CouponRepository couponRepository;
	
	public Coupon createCoupon(Coupon coupon) {
		CouponDO couponDO = new  CouponDO();
		BeanUtils.copyProperties(coupon, couponDO);
		CouponDO responseDO = couponRepository.save(couponDO);
		Coupon response = new Coupon();
		BeanUtils.copyProperties(responseDO, response);
		return response;
	}
	
	public boolean isValidCoupon(String coupon) {
		return couponManager.isValidCoupon(coupon);
		
	}
	

}
