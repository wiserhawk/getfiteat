package com.indhawk.foods.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.indhawk.foods.facade.FoodCategoryServiceFacade;
import com.indhawk.foods.request.FoodCategoryRequest;
import com.indhawk.foods.request.validator.RequestValidator;
import com.indhawk.foods.response.FoodCategoryResponse;

@RestController
public class FoodCategoryContoller {

	private static final Logger LOG = LoggerFactory.getLogger(FoodCategoryContoller.class);

	@Autowired
	@Qualifier("foodCategoryRequestValidator")
	private RequestValidator foodCategoryRequestValidator;

	@Autowired
	@Qualifier("foodCategoryServiceFacade")
	private FoodCategoryServiceFacade foodCategoryServiceFacade;

	/**
	 * This request mapper will fetch all food categories types with its food
	 * category IDs. for example CONTINENTAL, NORTH INDIAN, SOUTH INDIAN etc.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/foods/category/getAllFoodCategories", method = RequestMethod.GET)
	public ResponseEntity<List<FoodCategoryResponse>> getAllFoodCategories() {
		long startTime = System.currentTimeMillis();
		List<FoodCategoryResponse> foodCatList = foodCategoryServiceFacade.getFoodCategories();
		long executionTime = System.currentTimeMillis() - startTime;
		foodCatList.stream().forEach(r -> {
			r.setExecutionTime(executionTime);
		});
		ResponseEntity<List<FoodCategoryResponse>> respnose = new ResponseEntity<List<FoodCategoryResponse>>(foodCatList, HttpStatus.OK);
		return respnose;
	}

	/**
	 * This request mapper will create new food category for system.
	 * 
	 * @param reqeust
	 * @return
	 */
	@RequestMapping(value = "/foods/category/save", method = RequestMethod.POST)
	public ResponseEntity<Boolean> createFoodCategory(@RequestBody FoodCategoryRequest request) {
		ResponseEntity<Boolean> respnose = null;
		if (foodCategoryRequestValidator.validate(request)) {
			boolean result = foodCategoryServiceFacade.saveFoodCategory(request);
			respnose = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		} else {
			respnose = new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		return respnose;
	}

	/**
	 * This request mapper will update existing food category for system.
	 * 
	 * @param reqeust
	 * @return
	 */
	@RequestMapping(value = "/foods/category/update", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> updateFoodCategory(@RequestBody FoodCategoryRequest request) {
		ResponseEntity<Boolean> respnose = null;
		if (foodCategoryRequestValidator.validate(request)) {
			boolean result = foodCategoryServiceFacade.saveFoodCategory(request);
			respnose = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		} else {
			respnose = new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		return respnose;
	}

	/**
	 * This request mapper will delete food category using category ID.
	 * 
	 * @param catId
	 * @return
	 */
	@RequestMapping(value = "/foods/category/delete/{catId}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteFoodCategory(@PathVariable("catId") String catId) {
		ResponseEntity<Boolean> respnose = null;
		if (!StringUtils.isEmpty(catId)) {
			boolean result = foodCategoryServiceFacade.deleteFoodCategory(catId);
			respnose = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		} else {
			respnose = new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		return respnose;
	}

}
