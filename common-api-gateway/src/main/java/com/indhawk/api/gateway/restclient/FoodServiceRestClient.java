package com.indhawk.api.gateway.restclient;

import org.springframework.http.ResponseEntity;

import com.indhawk.api.gateway.food.request.FoodItemRequest;

public interface FoodServiceRestClient {
	String getRootURL();
	
	ResponseEntity<Object> getAllFoodItems();
	
	ResponseEntity<Object> getAllActiveFoodItems();
	
	ResponseEntity<Object> getFoodItemById(String id);
	
	ResponseEntity<Object> getFoodItemsByMenu(String menu);
	
	ResponseEntity<Object> createFoodItem(FoodItemRequest item);
	
	ResponseEntity<Object> updateFoodItem(FoodItemRequest item);
	
	ResponseEntity<Object> deleteFoodItem(String id);
	

}
