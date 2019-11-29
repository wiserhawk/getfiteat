package com.indhawk.getfiteat.foods.request.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.indhawk.getfiteat.foods.request.RestRequest;

@Component(value="foodRequestValidator")
public class FoodRequestValidator implements RequestValidator {
	
	private static final Logger LOG = LoggerFactory.getLogger(FoodRequestValidator.class);

	@Override
	public boolean validate(RestRequest request) {
		// TODO Auto-generated method stub
		return true;
	}

}
