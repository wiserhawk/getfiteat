package com.indhawk.billing.coupon;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.indhawk.billing.dataobj.CouponDO;
import com.indhawk.billing.repository.CouponRepository;

@Component
public class CouponManager {
	
	private static final Logger LOG = LoggerFactory.getLogger(CouponManager.class);
	
	@Autowired
	private CouponRepository couponRepository;
	
	private static final Map<String, Coupon> COUPON_CACHE = new HashMap<>();
	
	public CouponManager() {
		super();
	}
	
	public synchronized void init() {
		COUPON_CACHE.clear();
		LOG.info("Coupon cache cleared successful");
		try {
			couponRepository.findAll().stream().forEach(c -> {
				Coupon coupon = new Coupon(); 
				BeanUtils.copyProperties(c, coupon);
				COUPON_CACHE.put(c.getCoupon(), coupon);
			});
			LOG.info("Coupon cache initialization successful, CouponSize={}", COUPON_CACHE.size());
		} catch (Exception e) {
			LOG.error("Coupon cache initialization failed.", e);
		}
			
	}
	
	public boolean isValidCoupon(String coupon) {
		Coupon c = COUPON_CACHE.get(coupon);
		if (c == null) {
			return false;
		}
		
		// Check whether coupon is expired 
		if (isCouponExpired(c)) 
			return false;
		 
		return true;
	}
	
	public double computeCouponDiscount(String coupon, double payable) {
		Coupon c = COUPON_CACHE.get(coupon);
		if (c == null) {
			throw new NullPointerException("Coupon not found.");
		}
		CouponCalculator calculator = CouponCalculatorFactory.getCouponCalculator(c.getDiscountType());
		return calculator.calculate(c, payable);
		
	}
	
	public  boolean isCouponExpired(String coupon) {
		Coupon c = COUPON_CACHE.get(coupon);
		if (c == null) {
			throw new NullPointerException("Coupon not found.");
		}
		return isCouponExpired(c);
	}
	
	private boolean isCouponExpired(Coupon coupon) {
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
