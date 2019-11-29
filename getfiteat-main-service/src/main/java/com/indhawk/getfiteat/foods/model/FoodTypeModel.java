package com.indhawk.getfiteat.foods.model;

import org.springframework.stereotype.Component;

@Component(value="foodTypeModel")
public class FoodTypeModel {

	String id;
	
	String name;
	
	String description;
	
	boolean isActive;
	
	public FoodTypeModel() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		return "FoodTypeModel [id=" + id + ", name=" + name + ", description=" + description + ", isActive=" + isActive
				+ "]";
	}

}
