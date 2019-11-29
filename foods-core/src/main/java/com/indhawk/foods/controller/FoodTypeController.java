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

import com.indhawk.foods.facade.FoodTypeServiceFacade;
import com.indhawk.foods.request.FoodTypeRequest;
import com.indhawk.foods.request.validator.RequestValidator;
import com.indhawk.foods.response.FoodTypeResponse;

@RestController
public class FoodTypeController {

	private static final Logger LOG = LoggerFactory.getLogger(FoodTypeController.class);

	@Autowired
	@Qualifier("foodTypeRequestValidator")
	private RequestValidator foodTypeRequestValidator;

	@Autowired
	private FoodTypeServiceFacade foodTypeServiceFacade;

	/**
	 * This request mapper will fetch all food types types with its food type IDs.
	 * for example Fat-Loss Diet, Muscle-Gain Diet, Gluten-Free Diet, Ragular Diet
	 * etc.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/foods/type/getAllFoodTypes", method = RequestMethod.GET)
	public ResponseEntity<List<FoodTypeResponse>> getAllFoodTypes() {
		long startTime = System.currentTimeMillis();
		ResponseEntity<List<FoodTypeResponse>> respnose = null;
		List<FoodTypeResponse> foodTypeList = foodTypeServiceFacade.getFoodTypes();
		long executionTime = System.currentTimeMillis() - startTime;
		foodTypeList.stream().forEach(r -> {
			r.setExecutionTime(executionTime);
		});
		respnose = new ResponseEntity<List<FoodTypeResponse>>(foodTypeList, HttpStatus.OK);
		return respnose;
	}

	/**
	 * This request mapper will create new food type for system.
	 * 
	 * @param reqeust
	 * @return
	 */
	@RequestMapping(value = "/foods/type/save", method = RequestMethod.POST)
	public ResponseEntity<Boolean> createFoodType(@RequestBody FoodTypeRequest request) {
		ResponseEntity<Boolean> respnose = null;
		if (foodTypeRequestValidator.validate(request)) {
			boolean result = foodTypeServiceFacade.saveFoodType(request);
			respnose = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		} else {
			respnose = new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		return respnose;
	}

	/**
	 * This request mapper will update existing food type for system.
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/foods/type/update", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> updateFoodType(@RequestBody FoodTypeRequest request) {
		ResponseEntity<Boolean> respnose = null;
		if (foodTypeRequestValidator.validate(request)) {
			boolean result = foodTypeServiceFacade.saveFoodType(request);
			respnose = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		} else {
			respnose = new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		return respnose;
	}

	/**
	 * This request mapper will delete food type using type ID.
	 * 
	 * @param typeId
	 * @return
	 */
	@RequestMapping(value = "/foods/type/delete/{typeId}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteFoodType(@PathVariable("typeId") String typeId) {
		ResponseEntity<Boolean> respnose = null;
		if (!StringUtils.isEmpty(typeId)) {
			boolean result = foodTypeServiceFacade.deleteFoodType(typeId);
			respnose = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		} else {
			respnose = new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		return respnose;
	}

}
