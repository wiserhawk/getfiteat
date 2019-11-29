package com.indhawk.foods.response;

public class FoodTypeResponse extends GenericResponse {

	String id;
	
	String name;
	
	String description;
	
	boolean isActive;
	
	public FoodTypeResponse() {
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
		return "FoodTypeResponse [id=" + id + ", name=" + name + ", description=" + description + ", isActive="
				+ isActive + "]";
	}

}