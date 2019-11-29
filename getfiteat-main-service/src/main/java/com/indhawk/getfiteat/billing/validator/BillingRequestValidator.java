package com.indhawk.getfiteat.billing.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.indhawk.getfiteat.billing.request.BillCalculationRequest;
import com.indhawk.getfiteat.billing.request.Item;

@Component
public class BillingRequestValidator {
	
	public boolean validate(BillCalculationRequest request) {
		if (request == null) 
			return false;
		if (request.getItemList() == null || request.getItemList().size() == 0) 
			return false;
		boolean isValid = false;
		/*for(Item i : request.getItemList()) {
			if (StringUtils.isEmpty(i.getId()) || i.getPrice() <= 0 || i.getQuantity() <= 0) {
				 isValid= false;
				 return isValid;
			}
		}*/
		return true;
	}

}
