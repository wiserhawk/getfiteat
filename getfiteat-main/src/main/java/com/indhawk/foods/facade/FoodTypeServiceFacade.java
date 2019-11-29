package com.indhawk.foods.facade;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.indhawk.foods.model.FoodTypeModel;
import com.indhawk.foods.request.FoodTypeRequest;
import com.indhawk.foods.response.FoodTypeResponse;
import com.indhawk.foods.service.FoodTypeService;


@Component(value="foodTypeServiceFacade")
public class FoodTypeServiceFacade {

	private static final Logger LOG = LoggerFactory.getLogger(FoodTypeServiceFacade.class);

	@Autowired
	private FoodTypeService foodTypeService;
	
	public boolean saveFoodType(FoodTypeRequest request) {
		return foodTypeService.saveFoodType(request);
	}
	
	public List<FoodTypeResponse> getFoodTypes() {
		List<FoodTypeModel> models = foodTypeService.getFoodTypes();
		List<FoodTypeResponse> responses = new ArrayList<>();
		models.stream().forEach(m -> {
			FoodTypeResponse r = new FoodTypeResponse();
			BeanUtils.copyProperties(m, r);
			responses.add(r);
		});
		return responses;
	}
	
	public boolean deleteFoodType(String typeId) {
		return foodTypeService.deleteFoodType(typeId);
	}

}
