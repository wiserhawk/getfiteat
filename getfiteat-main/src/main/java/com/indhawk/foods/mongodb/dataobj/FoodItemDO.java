package com.indhawk.foods.mongodb.dataobj;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.indhawk.foods.model.NutritionFacts;

@Document(collection="FoodItems")
public class FoodItemDO {

	@Id
	String itemId;

	String name;
	
	@Indexed(direction=IndexDirection.ASCENDING)
	double price;
	
	double discountedPrice;
	
	/** Continental, North Indian, South Indian, Mexican */
	String category;
	String categoryId;
	
	/** VEG /NON-VEG */
	String type;
	String typeId;
	
	String menu;
	
	String image;
	
	boolean isActive;
	
	String recipe;
	
	String description;
	
	String ingredients;
	
	NutritionFacts nutritionFacts;

	public FoodItemDO() {
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

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * VEG / NON-VEG
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * VEG / NON-VEG
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public NutritionFacts getNutritionFacts() {
		return nutritionFacts;
	}

	public void setNutritionFacts(NutritionFacts nutritionFacts) {
		this.nutritionFacts = nutritionFacts;
	}

	@Override
	public String toString() {
		return "FoodItemDO [itemId=" + itemId + ", name=" + name + ", price=" + price + ", discountedPrice="
				+ discountedPrice + ", category=" + category + ", categoryId=" + categoryId + ", type=" + type
				+ ", typeId=" + typeId + ", menu=" + menu + ", image=" + image + ", isActive=" + isActive + ", recipe="
				+ recipe + ", description=" + description + ", ingredients=" + ingredients + ", nutritionFacts="
				+ nutritionFacts + "]";
	}

	
}
