package com.indhawk.getfiteat.user.manager.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.indhawk.getfiteat.user.manager.request.AddressRequest;
import com.indhawk.getfiteat.user.manager.request.Request;
import com.indhawk.getfiteat.user.manager.util.FormatUtil;

@Component("addressRequestValidator")
public class AddressRequestValidator implements RequestValidator {

	@Override
	public boolean validate(Request request) {
		AddressRequest addressReq = null;
		if (isRequestNotNull(request)) {
			try {
				addressReq = (AddressRequest) request;
			} catch (Exception e) {
				throw new RuntimeException("Not a valid request Object.");
			}
			
			if (StringUtils.isEmpty(addressReq.getUserId())) {
				throw new RuntimeException("UserID cannot be null or empty.");
			}
			
			if (StringUtils.isEmpty(addressReq.getAddressType())) {
				throw new RuntimeException("Address type cannot be null or empty.");
			}
			
			if (StringUtils.isEmpty(addressReq.getStreet())) {
				throw new RuntimeException("Street detail cannot be null or empty.");
			}
			
			if (StringUtils.isEmpty(addressReq.getArea())) {
				throw new RuntimeException("Area detail cannot be null or empty.");
			}
			
			if (StringUtils.isEmpty(addressReq.getState())) {
				throw new RuntimeException("State cannot be null or empty.");
			}
			
			if (StringUtils.isEmpty(addressReq.getPincode())) {
				throw new RuntimeException("Pincode cannot be null or empty.");
			}
			
			if (addressReq.getPincode().length() != 6) {
		    	throw new RuntimeException("Pincode must be 6 digit long.");
		    }
			
			if (!FormatUtil.isNumber(addressReq.getPincode())) {
		    	throw new RuntimeException("Pincode must have all numeric characters.");
		    }
			
			if (!FormatUtil.isNumber(addressReq.getPhone())) {
		    	throw new RuntimeException("Phone number must have all numeric characters.");
		    }
			
			if (StringUtils.isEmpty(addressReq.getPhone())) {
		    	throw new RuntimeException("Phone number cannot be null or empty.");
		    }
			
			if (addressReq.getPhone().length() != 10) {
		    	throw new RuntimeException("Phone number must be 10 digit long.");
		    }
			
		    if (!FormatUtil.isNumber(addressReq.getPhone())) {
		    	throw new RuntimeException("Phone number must have all numeric characters.");
		    }
		    return true;
		}
		return false;
	}

}
