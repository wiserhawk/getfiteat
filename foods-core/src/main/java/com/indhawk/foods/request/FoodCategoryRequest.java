package com.indhawk.foods.request;

public class FoodCategoryRequest implements RestRequest {

	String catId;
	
	String name;
	
	String description;
	
	boolean isActive;

	public FoodCategoryRequest() {
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
		return "FoodCategoryRequest [catId=" + catId + ", name=" + name + ", description=" + description + ", isActive="
				+ isActive + "]";
	}

}
