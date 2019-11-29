package com.indhawk.billing.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.indhawk.billing.dataobj.CouponDO;

@Repository
public interface CouponRepository extends MongoRepository<CouponDO, String>{

	public CouponDO getCouponByCoupon(String coupon);
	
}
