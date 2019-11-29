package com.indhawk.getfiteat.foods.facade;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.indhawk.getfiteat.foods.model.FoodCategoryModel;
import com.indhawk.getfiteat.foods.request.FoodCategoryRequest;
import com.indhawk.getfiteat.foods.response.FoodCategoryResponse;
import com.indhawk.getfiteat.foods.service.FoodCategoryService;


@Component(value="foodCategoryServiceFacade")
public class FoodCategoryServiceFacade {
	
private static final Logger LOG = LoggerFactory.getLogger(FoodCategoryServiceFacade.class);
	
	@Autowired
	private FoodCategoryService foodCategoryService;
	
	public boolean saveFoodCategory(FoodCategoryRequest request) {
		return foodCategoryService.saveFoodCategory(request);
	}
	
	public List<FoodCategoryResponse> getFoodCategories() {
		List<FoodCategoryModel> models = foodCategoryService.getFoodCategories();
		List<FoodCategoryResponse> responses = new ArrayList<>();
		models.stream().forEach(m -> {
			FoodCategoryResponse r = new FoodCategoryResponse();
			BeanUtils.copyProperties(m, r);
			responses.add(r);
		});
		return responses;
	}
	
	public FoodCategoryResponse getFoodCategoryById(String catId) {
		FoodCategoryModel m = foodCategoryService.getFoodCategoryById(catId);
		FoodCategoryResponse r = new FoodCategoryResponse();
		BeanUtils.copyProperties(m, r);
		return r;
	}
	
	public boolean deleteFoodCategory(String catId) {
		return foodCategoryService.deleteFoodCategory(catId);
	}

}
