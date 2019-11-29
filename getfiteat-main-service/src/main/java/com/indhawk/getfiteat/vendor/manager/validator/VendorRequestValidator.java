package com.indhawk.getfiteat.vendor.manager.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.indhawk.getfiteat.vendor.manager.request.VendorRequest;

@Component
public class VendorRequestValidator {
	
	private static final Logger LOG = LoggerFactory.getLogger(VendorRequestValidator.class);
	
	public boolean validate(VendorRequest request) {
		if (request == null) return false;
		
		return true;
	}

}
