package com.indhawk.api.gateway.food.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.indhawk.api.gateway.food.request.FoodItemRequest;
import com.indhawk.api.gateway.restclient.FoodServiceRestClient;

@RestController
public class FoodGatewayContoller {
	
	private static final Logger LOG = LoggerFactory.getLogger(FoodGatewayContoller.class);

	@Autowired
	@Qualifier("foodServiceRestClientImpl")
	private FoodServiceRestClient foodServiceRestClient;

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/api-gateway/food/getAllFoodItems", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllFoodItems() {
		LOG.info("Request recieved for getAllFoodItems");
		ResponseEntity<Object> response = foodServiceRestClient.getAllFoodItems();
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/api-gateway/food/getAllActiveFoodItems", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllActiveFoodItems() {
		LOG.info("Request recieved for getAllActiveFoodItems");
		ResponseEntity<Object> response = foodServiceRestClient.getAllActiveFoodItems();
		return response;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/api-gateway/food/getFoodItemById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getFoodItemsById(@PathVariable("id") String id) {
		LOG.info("Request recieved for getFoodItemsById");
		ResponseEntity<Object> response = foodServiceRestClient.getFoodItemById(id);
		return response;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/api-gateway/food/getFoodItemsByMenu/{menu}", method = RequestMethod.GET)
	public ResponseEntity<Object> getFoodItemsByMenu(@PathVariable("menu") String menu) {
		LOG.info("Request recieved for getFoodItemsByMenu");
		ResponseEntity<Object> response = foodServiceRestClient.getFoodItemsByMenu(menu);
		return response;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/api-gateway/food/save", method = RequestMethod.GET)
	public ResponseEntity<Object> createFoodItem(@RequestBody FoodItemRequest request) {
		LOG.info("Request recieved for createFoodItem");
		ResponseEntity<Object> response = foodServiceRestClient.createFoodItem(request);
		return response;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/api-gateway/food/update", method = RequestMethod.GET)
	public ResponseEntity<Object> updateFoodItem(@RequestBody FoodItemRequest request) {
		LOG.info("Request recieved for updateFoodItem");
		ResponseEntity<Object> response = foodServiceRestClient.updateFoodItem(request);
		return response;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/api-gateway/food/delete/{foodId}", method = RequestMethod.GET)
	public ResponseEntity<Object> deleteFoodItem(@PathVariable("foodId") String foodId) {
		LOG.info("Request recieved for deleteFoodItem");
		ResponseEntity<Object> response = foodServiceRestClient.deleteFoodItem(foodId);
		return response;
	}

}
