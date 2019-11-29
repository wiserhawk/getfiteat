package com.indhawk.foods.request.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.indhawk.foods.request.RestRequest;

@Component(value="foodCategoryRequestValidator")
public class FoodCategoryRequestValidator implements RequestValidator {
	
	private static final Logger LOG = LoggerFactory.getLogger(FoodCategoryRequestValidator.class);

	@Override
	public boolean validate(RestRequest request) {
		// TODO Auto-generated method stub
		return true;
	}

}
