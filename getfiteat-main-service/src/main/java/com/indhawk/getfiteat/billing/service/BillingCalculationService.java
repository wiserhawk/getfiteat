package com.indhawk.getfiteat.billing.service;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.indhawk.getfiteat.billing.coupon.CouponManager;
import com.indhawk.getfiteat.billing.gst.GSTDetails;
import com.indhawk.getfiteat.billing.gst.GSTManager;
import com.indhawk.getfiteat.billing.gst.GSTProductType;
import com.indhawk.getfiteat.billing.model.CalculatedBillModel;
import com.indhawk.getfiteat.billing.model.ItemModel;

@Service
public class BillingCalculationService {
	
	private static final Logger LOG = LoggerFactory.getLogger(BillingCalculationService.class);
	
	@Autowired
	private GSTManager gstManager;
	
	@Autowired
	private CouponManager couponManager;
	
	@Value("${free.delivery.Amount}")
	private int freeDeliveryAmount; 
	
	@Value("${delivery.charge}")
	private int deliveryCharge; 
	
	public CalculatedBillModel calcuateFoodBillWithGST(List<ItemModel> items, String coupon) {
		
		GSTDetails gst = gstManager.getGSTDetail(GSTProductType.FOOD);
		BigDecimal totalPrice = BigDecimal.ZERO;
		for (ItemModel i : items) {
			BigDecimal price = i.getPrice();
			int quantity = i.getQuantity();
			BigDecimal itemPrice = price.multiply(new BigDecimal(quantity));
			totalPrice = totalPrice.add(itemPrice);
		};
		
		BigDecimal netTotalPrice = new BigDecimal(totalPrice.doubleValue());
		
		
		// Calculate combined or total GST
		float gstPercent = gst.getGst();
		BigDecimal gstTotalAmount = calcAmountOfPercentage(netTotalPrice, gstPercent);
		
		//Calculate CGST
		float cgstPercent = gst.getCgst();
		BigDecimal cgstAmount = calcAmountOfPercentage(netTotalPrice, cgstPercent);
		
		//Calculate CGST
		float sgstPercent = gst.getSgst();
		BigDecimal sgstAmount = calcAmountOfPercentage(netTotalPrice, sgstPercent);
		
		
		
		// Calculate Amount after applying (Adding) total GST.
		netTotalPrice = netTotalPrice.add(gstTotalAmount);
		
		// Calculate Delivery Charges
		int deliveryFee = deliveryCharge;
		if (netTotalPrice.doubleValue() >= freeDeliveryAmount) {
			deliveryFee = 0;
		}
		netTotalPrice = netTotalPrice.add(new BigDecimal(deliveryFee));
		
		// Apply Coupon Discount if any
		BigDecimal cpnDiscountAmount = getCouponDiscountAmount(totalPrice, coupon);
		BigDecimal payable = netTotalPrice.subtract(cpnDiscountAmount).setScale(0, BigDecimal.ROUND_CEILING);
		
		CalculatedBillModel model = new CalculatedBillModel();
		model.setItemsList(items);
		model.setTotalPrice(totalPrice.setScale(2));
		model.setDeliveryCharge(new BigDecimal(deliveryFee).setScale(2));
		model.setCouponDiscount(cpnDiscountAmount.setScale(2));
		model.setGst(gstTotalAmount.setScale(2));
		model.setCgst(cgstAmount.setScale(2));
		model.setSgst(sgstAmount.setScale(2));
		model.setPayable(payable.setScale(2));
		
		return model;
	}
	
	private BigDecimal getCouponDiscountAmount(BigDecimal totalPrice, String coupon) {
		if (StringUtils.isEmpty(coupon))
			return BigDecimal.ZERO;
		double discount = getCouponDiscount(coupon, totalPrice.doubleValue());
		BigDecimal discountAmount = new BigDecimal(discount);
		return discountAmount;
	}
	
	private double getCouponDiscount(String coupon, double amount) {
		try {
			if (!couponManager.isValidCoupon(coupon))
				return 0.00;
			return couponManager.computeCouponDiscount(coupon, amount);
		} catch (Exception ex) {
			LOG.error(ex.getMessage());
		}
		return 0.00;
	}
	
	private BigDecimal calcAmountOfPercentage(BigDecimal baseAmount, float percent) {
		return baseAmount.multiply(new BigDecimal(percent)).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_CEILING);
	}
	
	
	
	
	
	

}
