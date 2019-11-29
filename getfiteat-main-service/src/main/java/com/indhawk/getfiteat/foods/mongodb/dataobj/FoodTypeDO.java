package com.indhawk.getfiteat.foods.mongodb.dataobj;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="FoodTypes")
public class FoodTypeDO {
	
	@Id
	String typeId;
	
	String name;
	
	String description;
	
	boolean isActive;

	public FoodTypeDO() {
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
		return "FoodTypeDO [typeId=" + typeId + ", name=" + name + ", description=" + description + ", isActive="
				+ isActive + "]";
	}

}
