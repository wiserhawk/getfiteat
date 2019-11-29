package com.indhawk.foods.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.indhawk.foods.facade.FoodServiceFacade;
import com.indhawk.foods.request.FoodItemRequest;
import com.indhawk.foods.request.validator.RequestValidator;
import com.indhawk.foods.response.FoodItemResponse;

/**
 * This {@link FoodItemContoller} is Spring Boot controller to manage Food items
 * management.
 * 
 * @author MJ
 */

@RestController()
public class FoodItemContoller {

	private static final Logger LOG = LoggerFactory.getLogger(FoodItemContoller.class);

	@Autowired
	@Qualifier("foodRequestValidator")
	private RequestValidator foodRequestValidator;

	@Autowired
	private FoodServiceFacade foodServiceFacade;

	/**
	 * This request mapper will fetch all food items and return it as response.
	 * 
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/foods/getAllItems", method = RequestMethod.GET)
	public ResponseEntity<List<FoodItemResponse>> getAllFoodItems() {
		long startTime = System.currentTimeMillis();
		List<FoodItemResponse> foodItemList = foodServiceFacade.getFoodItems();
		long executionTime = System.currentTimeMillis() - startTime;
		foodItemList.stream().forEach(r -> {
			r.setExecutionTime(executionTime);
		});
		ResponseEntity<List<FoodItemResponse>> respnose = new ResponseEntity<List<FoodItemResponse>>(foodItemList, HttpStatus.OK);
		return respnose;
	}
	
	/**
	 * This request mapper will fetch all food items and return it as response.
	 * 
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/foods/getAllActiveItems", method = RequestMethod.GET)
	public ResponseEntity<List<FoodItemResponse>> getAllActiveFoodItems() {
		long startTime = System.currentTimeMillis();
		List<FoodItemResponse> foodItemList = foodServiceFacade.getAllActiveFoodItems();
		long executionTime = System.currentTimeMillis() - startTime;
		foodItemList.stream().forEach(r -> {
			r.setExecutionTime(executionTime);
		});
		ResponseEntity<List<FoodItemResponse>> respnose = new ResponseEntity<List<FoodItemResponse>>(foodItemList, HttpStatus.OK);
		return respnose;
	}

	/**
	 * This request mapper will fetch food item by food Item Id
	 * 
	 * @param id
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/foods/getItemById/{id}", method = RequestMethod.GET)
	public ResponseEntity<FoodItemResponse> getFoodItemsById(@PathVariable("id") String id) {
		ResponseEntity<FoodItemResponse> respnose = null;
		long startTime = System.currentTimeMillis();
		if (!StringUtils.isEmpty(id)) {
			FoodItemResponse result = foodServiceFacade.getFoodItemsById(id);
			long executionTime = System.currentTimeMillis() - startTime;
			result.setExecutionTime(executionTime);
			respnose = new ResponseEntity<FoodItemResponse>(result, HttpStatus.OK);
		} else {
			respnose = new ResponseEntity<FoodItemResponse>(HttpStatus.BAD_REQUEST);
		}
		return respnose;
	}
	
	/**
	 * This request mapper will fetch food item by food menu
	 * 
	 * @param menu e.g. Fat Loss, Muscle gain
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/foods/getItemsByMenu/{menu}", method = RequestMethod.GET)
	public ResponseEntity<List<FoodItemResponse>> getFoodItemsByMenu(@PathVariable("menu") String menu) {
		ResponseEntity<List<FoodItemResponse>> respnose = null;
		long startTime = System.currentTimeMillis();
		if (!StringUtils.isEmpty(menu)) {
			List<FoodItemResponse> result = foodServiceFacade.getFoodItemsByMenu(menu);
			long executionTime = System.currentTimeMillis() - startTime;
			LOG.info("/foods/getItemsByMenu/{menu} time taken={}", executionTime);
			respnose = new ResponseEntity<List<FoodItemResponse>>(result, HttpStatus.OK);
		} else {
			respnose = new ResponseEntity<List<FoodItemResponse>>(HttpStatus.BAD_REQUEST);
		}
		return respnose;
	}

	/**
	 * This request mapper will fetch limited food items in given range. This
	 * request can be use for food items paging.
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/foods/getItemsFromAndToLimit/{from}/{to}", method = RequestMethod.GET)
	public ResponseEntity<List<FoodItemResponse>> getFoodItemsFromAndToLimit(@PathVariable("from") int from,
			@PathVariable("to") int to) {
		/*RestResponse fackResponse = new GenericResponse(
				"NOT YET IMPLEMENTED !!! This mapper will return all food items from = " + from + " to = " + to + " range");
		ResponseEntity<RestResponse> respnose = new ResponseEntity<RestResponse>(fackResponse, HttpStatus.OK);*/
		return null;
	}

	/**
	 * This request mapper will fetch limited food items from given range to default
	 * limit. This request can be use for food items paging.
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/foods/getItemsFromToDefaultLimit/{from}", method = RequestMethod.GET)
	public ResponseEntity<List<FoodItemResponse>> getFoodItemsFromToDefaultLimit(@PathVariable("from") int from) {
		/*RestResponse fackResponse = new GenericResponse(
				"NOT YET IMPLEMENTED !!! This mapper will return all food items from = " + from + " to default limit for example 50.");
		ResponseEntity<RestResponse> respnose = new ResponseEntity<RestResponse>(fackResponse, HttpStatus.OK);*/
		return null;
	}

	/**
	 * This request mapper will fetch all food items for given food type ID.
	 * 
	 * @param foodTypeId
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/foods/getItemsByTypeId/{typeId}", method = RequestMethod.GET)
	public ResponseEntity<List<FoodItemResponse>> getFoodsByTypeId(@PathVariable("typeId") String typeId) {
		long startTime = System.currentTimeMillis();
		ResponseEntity<List<FoodItemResponse>> respnose = null;
		if (!StringUtils.isEmpty(typeId)) {
			List<FoodItemResponse> result = foodServiceFacade.getFoodItemsByTypeId(typeId);
			long executionTime = System.currentTimeMillis() - startTime;
			result.stream().forEach(r -> {
				r.setExecutionTime(executionTime);
			});
			respnose = new ResponseEntity<List<FoodItemResponse>>(result, HttpStatus.OK);
			return respnose;
		} else {
			respnose = new ResponseEntity<List<FoodItemResponse>>(HttpStatus.BAD_REQUEST);
		}
		return respnose;
	}

	/**
	 * This request mapper will fetch all food items for given food category ID.
	 * 
	 * @param foodTypeId
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/foods/getItemsByCategoryId/{categoryId}", method = RequestMethod.GET)
	public ResponseEntity<List<FoodItemResponse>> getFoodsByCategoryId(@PathVariable("categoryId") String categoryId) {
		long startTime = System.currentTimeMillis();
		ResponseEntity<List<FoodItemResponse>> respnose = null;
		if (!StringUtils.isEmpty(categoryId)) {
			List<FoodItemResponse> result = foodServiceFacade.getFoodItemsByCategoryId(categoryId);
			long executionTime = System.currentTimeMillis() - startTime;
			result.stream().forEach(r -> {
				r.setExecutionTime(executionTime);
			});
			respnose = new ResponseEntity<List<FoodItemResponse>>(result, HttpStatus.OK);
			return respnose;
		} else {
			respnose = new ResponseEntity<List<FoodItemResponse>>(HttpStatus.BAD_REQUEST);
		}
		return respnose;
	}

	/**
	 * This request mapper will create new food item for system.
	 * 
	 * @param reqeust
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/foods/save", method = RequestMethod.POST)
	public ResponseEntity<Boolean> createFoodItem(@RequestBody FoodItemRequest request) {
		ResponseEntity<Boolean> respnose = null;
		if (foodRequestValidator.validate(request)) {
			boolean result = foodServiceFacade.saveFoodItem(request);
			respnose = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		} else {
			respnose = new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		return respnose;
	}

	/**
	 * This request mapper will update existing food item for system.
	 * 
	 * @param reqeust
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/foods/update", method = RequestMethod.POST)
	public ResponseEntity<Boolean> updateFoodItem(@RequestBody FoodItemRequest request) {
		ResponseEntity<Boolean> respnose = null;
		if (foodRequestValidator.validate(request)) {
			boolean result = foodServiceFacade.saveFoodItem(request);
			respnose = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		} else {
			respnose = new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		return respnose;
	}

	/**
	 * This request mapper will delete food item using foodID.
	 * 
	 * @param foodId
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/foods/deleteById/{foodId}", method = RequestMethod.GET)
	public ResponseEntity<Boolean> deleteFoodItemById(@PathVariable("foodId") String id) {
		ResponseEntity<Boolean> respnose = null;
		if (!StringUtils.isEmpty(id)) {
			boolean result = foodServiceFacade.deleteFoodItemById(id);
			respnose = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		} else {
			respnose = new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		return respnose;
	}

	/**
	 * This is to test Food Service is running properly or not.
	 * 
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "foods/test", method = RequestMethod.GET)
	public String test() {
		return "Foods-Core Service is up and running. So TEST Successful!!!!!";
	}

}
