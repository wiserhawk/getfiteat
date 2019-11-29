package com.indhawk.api.gateway.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.indhawk.api.gateway.food.FoodServiceNavigationHelper;
import com.indhawk.api.gateway.food.request.FoodItemRequest;

@Component(value="foodServiceRestClientImpl")
public class FoodServiceRestClientImpl extends AbstractRestClient implements FoodServiceRestClient {
	
	@Value("${app.food.service.host}")
	private String appFoodServiceHost;
	
	@Value("${app.food.service.port}")
	private String appFoodServicePort;
	
	@Value("${app.food.service.get.all.food.items.url}")
	private String getAllFoodItemsURL;
	
	@Value("${app.food.service.get.all.active.food.items.url}")
	private String getAllActiveFoodItemsURL;
	
	@Value("${app.food.service.get.food.item.by.id.url}")
	private String getFoodItemByIdURL;
	
	@Value("${app.food.service.get.food.item.by.menu.url}")
	private String getFoodItemsByMenuURL;
	
	@Value("${app.food.service.create.food.item.url}")
	private String createFoodItemURL;
	
	@Value("${app.food.service.update.food.item.url}")
	private String updateFoodItemURL;
	
	@Value("${app.food.service.delete.food.item.url}")
	private String deleteFoodItemURL;
	
	@Autowired
	@Qualifier("foodServiceNavigationHelper")
	private FoodServiceNavigationHelper navigationHelper;
	
	@Override
	public String getRootURL() {
		StringBuilder builder = new StringBuilder();
		builder.append(appFoodServiceHost);
		builder.append(":");
		builder.append(appFoodServicePort);
		return builder.toString();
	}

	@Override
	public ResponseEntity<Object> getAllFoodItems() {
		String url = getRootURL() + getAllFoodItemsURL;
		ResponseEntity<Object> resposneEntity = getRestClient().getForEntity(url, Object.class);
		return resposneEntity;
	}

	@Override
	public ResponseEntity<Object> getAllActiveFoodItems() {
		String url = getRootURL() + getAllActiveFoodItemsURL;
		ResponseEntity<Object> resposneEntity = getRestClient().getForEntity(url, Object.class);
		return resposneEntity;
	}

	@Override
	public ResponseEntity<Object> getFoodItemById(String id) {
		String url = getRootURL() + getFoodItemByIdURL.replace("{id}", id);;
		ResponseEntity<Object> resposneEntity = getRestClient().getForEntity(url, Object.class);
		return resposneEntity;
	}

	@Override
	public ResponseEntity<Object> getFoodItemsByMenu(String menu) {
		String url = getRootURL() + getFoodItemByIdURL.replace("{menu}", menu);;
		ResponseEntity<Object> resposneEntity = getRestClient().getForEntity(url, Object.class);
		return resposneEntity;
	}

	@Override
	public ResponseEntity<Object> createFoodItem(FoodItemRequest item) {
		String url = getRootURL() + createFoodItemURL;
		ResponseEntity<Object> resposneEntity = getRestClient().postForEntity(url, item, Object.class);
		return resposneEntity;
	}

	@Override
	public ResponseEntity<Object> updateFoodItem(FoodItemRequest item) {
		String url = getRootURL() + createFoodItemURL;
		ResponseEntity<Object> resposneEntity = getRestClient().postForEntity(url, item, Object.class);
		return resposneEntity;
	}

	@Override
	public ResponseEntity<Object> deleteFoodItem(String id) {
		String url = getRootURL() + getFoodItemByIdURL.replace("{foodId}", id);;
		ResponseEntity<Object> resposneEntity = getRestClient().getForEntity(url, Object.class);
		return resposneEntity;
	}
	
	
	
	/*@Override
	public List<FoodItemModel> getAllFoodItems() {
		String url =  navigationHelper.getServiceDomainName() + foodServiceGetAllUrl;
		ResponseEntity<FoodItemModel[]> response = getRestClient().getForEntity(url, FoodItemModel[].class);
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
	
	
	
	
	@Override
	public FoodItemModel getFoodItemsById(String id) {
		RestTemplate rest = new RestTemplate();
		String url =  navigationHelper.getServiceDomainName() + foodServiceGetByIdUrl.replace("{id}", id);
		ResponseEntity<FoodItemModel> response = rest.exchange(url, HttpMethod.GET, null, FoodItemModel.class);
		FoodItemModel model = null;
		if (response.getStatusCode() == HttpStatus.OK) {
			model = response.getBody();
		}
		return model;
	}*/

}
