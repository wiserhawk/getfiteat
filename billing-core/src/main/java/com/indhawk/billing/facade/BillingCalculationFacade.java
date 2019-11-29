package com.indhawk.billing.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.indhawk.billing.model.CalculatedBillModel;
import com.indhawk.billing.model.ItemModel;
import com.indhawk.billing.request.Item;
import com.indhawk.billing.service.BillingCalculationService;

@Component
public class BillingCalculationFacade {
	
	private static final Logger LOG = LoggerFactory.getLogger(BillingCalculationFacade.class);
	
	@Autowired
	private BillingCalculationService billingCalculationService;
	
	
	public CalculatedBillModel calcuateFoodBillWithGST(List<Item> items, String coupon) {
		if (items == null || items.size() == 0)
			return null;
		List<ItemModel> itemModels = new ArrayList<>();
		items.stream().forEach(i -> {
			ItemModel m = new ItemModel();
			
			BeanUtils.copyProperties(i, m);
			m.setPrice(new BigDecimal(i.getPrice())); // Converting float to BigDecimal manually.
			
			itemModels.add(m);
		});
		return billingCalculationService.calcuateFoodBillWithGST(itemModels, coupon);
	}

}
