package com.indhawk.foods.mongodb.dataobj;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="FoodCategories")
public class FoodCategoryDO {
	
	@Id
	String catId;
	
	String name;
	
	String description;
	
	boolean isActive;

	public FoodCategoryDO() {
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
		return "FoodCategoryDO [catId=" + catId + ", name=" + name + ", description=" + description + ", isActive="
				+ isActive + "]";
	}

}
