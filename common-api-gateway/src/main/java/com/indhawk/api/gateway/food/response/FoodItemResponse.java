package com.indhawk.api.gateway.food.response;

import java.util.List;

public class FoodItemResponse extends GenericResponse {

	String foodItemId;
	
	String name;
	
	List<String> ingredients;
	
	/**
	 * For example Continental, North Indian, South Indian, Mexican
	 */
	List<String> categories; 
	
	String description;
	
	double price;
	
	double discountedPrice;
	
	// veg / non-veg etc
	String foodCategory;
	
	String imagePath;
	
	String recipe;
	
	long executionTime;


	public String getFoodItemId() {
		return foodItemId;
	}

	public void setFoodItemId(String foodItemId) {
		this.foodItemId = foodItemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	
	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}
	
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	public String getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}
	
	public long getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(long executionTime) {
		this.executionTime = executionTime;
	}

	@Override
	public String toString() {
		return "FoodItemModel [foodItemId=" + foodItemId + ", name=" + name + ", ingredients=" + ingredients
				+ ", categories=" + categories + ", description=" + description + ", price=" + price
				+ ", discountedPrice=" + discountedPrice + ", foodCategory=" + foodCategory + ", imagePath=" + imagePath
				+ ", recipe=" + recipe + ", executionTime=" + executionTime + "]";
	}
}
