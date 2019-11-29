package com.indhawk.api.gateway.food.model;

import java.util.ArrayList;
import java.util.List;

public class FoodItemModelList {
	
	private List<FoodItemModel> foodItemModels;

	public FoodItemModelList() {
		super();
		foodItemModels = new ArrayList<>();
	}

	public List<FoodItemModel> getFoodItemModels() {
		return foodItemModels;
	}

	public void setFoodItemModels(List<FoodItemModel> foodItemModels) {
		this.foodItemModels = foodItemModels;
	}

	

}
