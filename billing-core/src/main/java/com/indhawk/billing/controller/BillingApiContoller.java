package com.indhawk.billing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.indhawk.billing.coupon.Coupon;
import com.indhawk.billing.facade.BillingCalculationFacade;
import com.indhawk.billing.facade.CouponManagerFacade;
import com.indhawk.billing.model.CalculatedBillModel;
import com.indhawk.billing.request.BillCalculationRequest;
import com.indhawk.billing.request.CouponRequest;
import com.indhawk.billing.request.Item;
import com.indhawk.billing.validator.BillingRequestValidator;
import com.indhawk.billing.validator.CouponRequestValidator;

@RestController
public class BillingApiContoller {

	@Autowired
	private BillingCalculationFacade billingCalculationFacade;

	@Autowired
	private CouponManagerFacade couponManagerFacade;

	@Autowired
	private BillingRequestValidator billingRequestValidator;
	
	@Autowired
	private CouponRequestValidator couponRequestValidator;

	@CrossOrigin(origins="*")
	@RequestMapping(value = "billing/calculateBill", method = RequestMethod.POST)
	private ResponseEntity<Object> calculateBill(@RequestBody BillCalculationRequest request) {
		ResponseEntity<Object> response = null;
		if (billingRequestValidator.validate(request)) {
			/*
			 * ItemModel it1 = new ItemModel(); it1.setId("0001");
			 * it1.setName("Chicken pizza"); it1.setPrice(new BigDecimal(190));
			 * it1.setQuantity(1); it1.setType("FOOD");
			 * 
			 * ItemModel it2 = new ItemModel(); it2.setId("0002"); it2.setName("Omlate");
			 * it2.setPrice(new BigDecimal(250)); it2.setQuantity(2); it2.setType("FOOD");
			 * 
			 * List<ItemModel> items = new ArrayList<>(); items.add(it1); items.add(it2);
			 */
			List<Item> items = request.getItemList();
			String coupon = request.getCoupon();
			CalculatedBillModel model = billingCalculationFacade.calcuateFoodBillWithGST(items, coupon);
			response = new ResponseEntity<Object>(model, HttpStatus.OK);
		} else {
			response = new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "billing/createCoupon", method = RequestMethod.POST)
	private ResponseEntity<Object> createCoupon(@RequestBody CouponRequest coupon) {
		ResponseEntity<Object> response = null;
		try {
			if (couponRequestValidator.validate(coupon)) {
				
				Coupon couponModel = couponManagerFacade.createCoupon(coupon);
				response = new ResponseEntity<Object>(couponModel, HttpStatus.OK);
			}
		} catch (Exception e) {
			response = new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "billing/isValidCoupon/{coupon}", method = RequestMethod.GET)
	private ResponseEntity<Boolean> isCouponValid(@PathVariable("coupon") String coupon) {
		ResponseEntity<Boolean> response = null;
		if (!StringUtils.isEmpty(coupon)) {
			boolean result = couponManagerFacade.isValidCoupon(coupon);
			response = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		} else {
			response = new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@CrossOrigin(origins="*")
	@RequestMapping(value = "billing/initailzeCouponCache", method = RequestMethod.GET)
	private void initializeCouponCache() {
		couponManagerFacade.initalizeCouponCache();
	}
}
