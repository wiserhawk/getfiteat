package com.indhawk.api.gateway.food.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.indhawk.api.gateway.food.FoodServiceNavigationHelper;
import com.indhawk.api.gateway.food.model.FoodItemModel;
import com.indhawk.api.gateway.food.model.FoodItemModelList;

@Service
public class FoodService {
	
	private static final String GET_ALL_FOOD_ITEMS_URL = "/foods/getAll";
	
	private static final String GET_FOOD_ITEM_BY_ID_URL = "/foods/getById/{id}";
	
	@Autowired
	@Qualifier("foodServiceNavigationHelper")
	private FoodServiceNavigationHelper navigationHelper;
	
	/*public List<FoodItemModel> getAllFoodItems() {
		RestTemplate rest = new RestTemplate();
		String url =  navigationHelper.getServiceDomainName() + GET_ALL_FOOD_ITEMS_URL;
		ResponseEntity<FoodItemModelList> response = rest.getForEntity(url, FoodItemModelList.class);
		List<FoodItemModel> modelList = new ArrayList<>();
		if (response.getStatusCode() == HttpStatus.OK) {
			FoodItemModelList modelColleciton = response.getBody();
			List<FoodItemModel> models = modelColleciton.getFoodItemModels();
			models.stream().forEach(m -> {
				modelList.add(m);
			});
		}
		return modelList;
	}*/
	
	public List<FoodItemModel> getAllFoodItems() {
		RestTemplate rest = new RestTemplate();
		String url =  navigationHelper.getServiceDomainName() + GET_ALL_FOOD_ITEMS_URL;
		ResponseEntity<FoodItemModel[]> response = rest.getForEntity(url, FoodItemModel[].class);
		List<FoodItemModel> modelList = new ArrayList<>();
		if (response.getStatusCode() == HttpStatus.OK) {
			FoodItemModel[] modelColleciton = response.getBody();
			//List<FoodItemModel> models = modelColleciton.getFoodItemModels();
			Arrays.asList(modelColleciton).stream().forEach(m -> {
				modelList.add(m);
			});
		}
		return modelList;
	}
	
	
	/*public FoodItemModel getFoodItemsById(String id) {
		RestTemplate rest = new RestTemplate();
		String url =  navigationHelper.getServiceDomainName() + GET_FOOD_ITEM_BY_ID_URL.replace("{id}", id);
		ResponseEntity<FoodItemModel> response = rest.getForEntity(url, FoodItemModel.class);
		FoodItemModel model = null;
		if (response.getStatusCode() == HttpStatus.OK) {
			model = response.getBody();
			
		}
		return model;
	}
	*/
	public FoodItemModel getFoodItemsById(String id) {
		RestTemplate rest = new RestTemplate();
		String url =  navigationHelper.getServiceDomainName() + GET_FOOD_ITEM_BY_ID_URL.replace("{id}", id);
		ResponseEntity<FoodItemModel> response = rest.exchange(url, HttpMethod.GET, null, FoodItemModel.class);
		FoodItemModel model = null;
		if (response.getStatusCode() == HttpStatus.OK) {
			model = response.getBody();
			
		}
		return model;
	}

}
