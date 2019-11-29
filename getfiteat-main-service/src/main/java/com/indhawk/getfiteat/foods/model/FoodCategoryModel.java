package com.indhawk.getfiteat.foods.model;

import org.springframework.stereotype.Component;

@Component(value="foodCategoryModel")
public class FoodCategoryModel {

	String catId;
	
	String name;
	
	String description;
	
	boolean isActive;
	
	public FoodCategoryModel() {
		super();
	}

	public String getCatId() {
		return catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "FoodCategoryModel [catId=" + catId + ", name=" + name + ", description=" + description + ", isActive="
				+ isActive + "]";
	}

}
