package com.indhawk.foods.enums;

public enum FoodTypes {
	
	VEG("VEG"),
	NON_VEG("NON-VEG");
	
	String type;
	
	private FoodTypes(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

}
