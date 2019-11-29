package com.indhawk.getfiteat.foods.request;

public class FoodTypeRequest implements RestRequest {
	
	String typeId;
	
	String name;
	
	String description;
	
	boolean isActive;

	public FoodTypeRequest() {
		super();
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
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
		return "FoodTypeRequest [typeId=" + typeId + ", name=" + name + ", description=" + description + ", isActive="
				+ isActive + "]";
	}

}
