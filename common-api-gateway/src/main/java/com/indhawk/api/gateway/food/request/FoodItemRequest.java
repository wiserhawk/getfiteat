package com.indhawk.api.gateway.food.request;


public class FoodItemRequest {
	
	String itemId;

	String name;

	String description;
	
	double price;
	
	double discountedPrice;
	
	// Continental / American / Mexican
	String category;

	String recipe;

	String ingredients;

	// veg / non-veg etc
	String type;
	
	String menu;

	String image;
	
	boolean isActive;
	
	NutritionFacts nutritionFacts;

	public FoodItemRequest() {
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getMenu() {
		return menu;
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
		return "FoodItemRequest [itemId=" + itemId + ", name=" + name + ", description=" + description + ", price="
				+ price + ", discountedPrice=" + discountedPrice + ", category=" + category + ", recipe=" + recipe
				+ ", ingredients=" + ingredients + ", type=" + type + ", image=" + image + ", isActive=" + isActive
				+ ", nutritionFacts=" + nutritionFacts + "]";
	}

}
