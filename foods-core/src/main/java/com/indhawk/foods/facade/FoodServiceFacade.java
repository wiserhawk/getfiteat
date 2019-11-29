package com.indhawk.foods.facade;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.indhawk.foods.model.FoodItemModel;
import com.indhawk.foods.request.FoodItemRequest;
import com.indhawk.foods.response.FoodItemResponse;
import com.indhawk.foods.service.FoodItemService;

@Component("foodServiceFacade")
public class FoodServiceFacade {
	
	private static final Logger LOG = LoggerFactory.getLogger(FoodServiceFacade.class);
	
	@Autowired
	private FoodItemService foodItemService;
	
	public boolean saveFoodItem(FoodItemRequest request) {
		return foodItemService.saveFoodItem(request);
	}
	
	public List<FoodItemResponse> getFoodItems() {
		List<FoodItemModel> models = foodItemService.getAllFoodItems();
		List<FoodItemResponse> responses = new ArrayList<>();
		models.stream().forEach(m -> {
			FoodItemResponse r = new FoodItemResponse();
			BeanUtils.copyProperties(m, r);
			responses.add(r);
		});
		
		return responses;
	}
	
	public List<FoodItemResponse> getAllActiveFoodItems() {
		List<FoodItemModel> models = foodItemService.getAllActiveFoodItems();
		List<FoodItemResponse> responses = new ArrayList<>();
		models.stream()
		//.filter(i -> i.getMenu() == null ? false : i.getMenu().equalsIgnoreCase("true"))
		.forEach(m -> {
			FoodItemResponse r = new FoodItemResponse();
			BeanUtils.copyProperties(m, r);
			responses.add(r);
		});
		return responses;
	}
	

	
	public FoodItemResponse getFoodItemsById(String id) {
		FoodItemModel m = foodItemService.getFoodItemsById(id);
		FoodItemResponse r = new FoodItemResponse();
		BeanUtils.copyProperties(m, r);
		return r;
	}
	
	public List<FoodItemResponse> getFoodItemsByMenu(String menu) {
		List<FoodItemModel> models = foodItemService.getFoodItemsByMenu(menu);
		List<FoodItemResponse> responses = new ArrayList<>();
		models.stream().forEach(m -> {
			FoodItemResponse r = new FoodItemResponse();
			BeanUtils.copyProperties(m, r);
			responses.add(r);
		});
		
		return responses;
	}
	
	public List<FoodItemResponse> getFoodItemsByTypeId(String typeId) {
		List<FoodItemModel>  models = foodItemService.getFoodItemsByTypeId(typeId);
		List<FoodItemResponse> responses = new ArrayList<>();
		models.stream().forEach(m -> {
			FoodItemResponse r = new FoodItemResponse();
			BeanUtils.copyProperties(m, r);
			responses.add(r);
		});
		
		return responses;
	}
	
	public List<FoodItemResponse> getFoodItemsByCategoryId(String categoryId) {
		List<FoodItemModel>  models = foodItemService.getFoodItemsByCategoryId(categoryId);
		List<FoodItemResponse> responses = new ArrayList<>();
		models.stream().forEach(m -> {
			FoodItemResponse r = new FoodItemResponse();
			BeanUtils.copyProperties(m, r);
			responses.add(r);
		});
		
		return responses;
	}
	
	public boolean deleteFoodItemById(String id) {
		return foodItemService.deleteFoodItemById(id);
	}

}
