package com.indhawk.api.gateway.food.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.indhawk.api.gateway.food.model.FoodItemModel;
import com.indhawk.api.gateway.food.response.FoodItemResponse;
import com.indhawk.api.gateway.restclient.FoodServiceRestClient;

@Component
public class FoodServiceFacade {
	
	@Autowired
	@Qualifier("foodServiceRestClientImpl")
	private FoodServiceRestClient foodServiceRestClient;
	
	
	/*public List<FoodItemResponse> getAllFoodItems() {
		List<FoodItemModel> models = foodServiceRestClient.getAllFoodItems();
		List<FoodItemResponse> responses = new ArrayList<>();
		models.stream().forEach(m -> {
			FoodItemResponse r = new FoodItemResponse();
			BeanUtils.copyProperties(m, r);
			responses.add(r);
		});
		return responses;
	}
	
	public FoodItemResponse getFoodItemsById(String id) {
		FoodItemModel m = foodServiceRestClient.getFoodItemsById(id);
		FoodItemResponse r = new FoodItemResponse();
		BeanUtils.copyProperties(m, r);
		return r;
	}*/
	
}
