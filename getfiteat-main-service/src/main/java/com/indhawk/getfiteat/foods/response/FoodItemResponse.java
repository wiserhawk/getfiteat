package com.indhawk.getfiteat.foods.response;

import com.indhawk.getfiteat.foods.model.NutritionFacts;

public class FoodItemResponse extends GenericResponse {
	
	String itemId;
	
	String name;
	
	String ingredients;
	
	/**
	 * For example Continental, North Indian, South Indian, Mexican
	 */
	String category; 
	
	String description;
	
	double price;
	
	double discountedPrice;
	
	// veg / non-veg etc
	String type;
	
	// Fat Loss, Muscle Gain, PreWorkout, PostWorkout, Cure etc.
	String menu;
	
	String image;
	
	String recipe;
	
	boolean isActive;
	
	NutritionFacts nutritionFacts;

	public FoodItemResponse() {
		super();
	}
	
	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getMenu() {
		return this.menu;
	}
	
	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public NutritionFacts getNutritionFacts() {
		return nutritionFacts;
	}

	public void setNutritionFacts(NutritionFacts nutritionFacts) {
		this.nutritionFacts = nutritionFacts;
	}

	@Override
	public String toString() {
		return "FoodItemResponse [itemId=" + itemId + ", name=" + name + ", ingredients=" + ingredients + ", category="
				+ category + ", description=" + description + ", price=" + price + ", discountedPrice="
				+ discountedPrice + ", type=" + type + ", menu=" + menu + ", image=" + image + ", recipe=" + recipe
				+ ", isActive=" + isActive + ", nutritionFacts=" + nutritionFacts + "]";
	}


}
