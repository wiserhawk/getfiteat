package com.indhawk.getfiteat.foods.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indhawk.getfiteat.foods.model.FoodItemModel;
import com.indhawk.getfiteat.foods.mongodb.dataobj.FoodItemDO;
import com.indhawk.getfiteat.foods.mongodb.repository.FoodItemRepository;
import com.indhawk.getfiteat.foods.request.FoodItemRequest;

@Service(value = "foodItemService")
public class FoodItemService {

	private static final Logger LOG = LoggerFactory.getLogger(FoodItemService.class);

	@Autowired
	private FoodItemRepository foodItemRepository;

	public boolean saveFoodItem(FoodItemRequest request) {
		FoodItemDO foodItemDo = new FoodItemDO();
		try {
			BeanUtils.copyProperties(request, foodItemDo);
			FoodItemDO item = foodItemRepository.save(foodItemDo);
			if (item != null) return true;
			else return false;
		} catch (Exception e) {
			LOG.error("Error: Failed to save new food item in DB.", e);
			return false;
		}

	}
	
	public List<FoodItemModel> getAllFoodItems() {
		List<FoodItemModel> foodItemModelList = new ArrayList<>();
		List<FoodItemDO> foodItemDoList = foodItemRepository.findAll();
		foodItemDoList.stream().forEach(i -> {
			FoodItemModel m = new FoodItemModel();
			BeanUtils.copyProperties(i, m);
			foodItemModelList.add(m);
		});
		return foodItemModelList;
	}
	
	public List<FoodItemModel> getAllActiveFoodItems() {
		List<FoodItemModel> foodItemModelList = new ArrayList<>();
		List<FoodItemDO> foodItemDoList = foodItemRepository.findAll();
		foodItemDoList.stream()
		.filter(i -> i.isActive() == true)
		.forEach(i -> {
			FoodItemModel m = new FoodItemModel();
			BeanUtils.copyProperties(i, m);
			foodItemModelList.add(m);
		});
		return foodItemModelList;
	}
	
	 public List<FoodItemModel> getFoodItemsByMenu(String menu) {
		 List<FoodItemModel> foodItemModelList = new ArrayList<>();
			List<FoodItemDO> foodItemDoList = foodItemRepository.getFoodItemsByMenu(menu);
			foodItemDoList.stream().forEach(i -> {
				FoodItemModel m = new FoodItemModel();
				BeanUtils.copyProperties(i, m);
				foodItemModelList.add(m);
			});
			return foodItemModelList;
	 }
	
	public FoodItemModel getFoodItemsById(String id) {
		Optional<FoodItemDO> foodItemOptional = foodItemRepository.findById(id);
		FoodItemDO foodItemDO = foodItemOptional.get();
		FoodItemModel model = new FoodItemModel();
		BeanUtils.copyProperties(foodItemDO, model);
		return model;
	}
	
	public List<FoodItemModel> getFoodItemsByTypeId(String typeId) {
		List<FoodItemModel> foodItemModelList = new ArrayList<>();
		List<FoodItemDO> foodItemDoList = foodItemRepository.getFoodItemsByTypeId(typeId);
		foodItemDoList.stream().forEach(i -> {
			FoodItemModel m = new FoodItemModel();
			BeanUtils.copyProperties(i, m);
			foodItemModelList.add(m);
		});
		return foodItemModelList;
	}
	
	public List<FoodItemModel> getFoodItemsByCategoryId(String categoryId) {
		List<FoodItemModel> foodItemModelList = new ArrayList<>();
		List<FoodItemDO> foodItemDoList = foodItemRepository.getFoodItemsByCategoryId(categoryId);
		foodItemDoList.stream().forEach(i -> {
			FoodItemModel m = new FoodItemModel();
			BeanUtils.copyProperties(i, m);
			foodItemModelList.add(m);
		});
		return foodItemModelList;
	}
	
	public boolean deleteFoodItemById(String id) {
		try {
			foodItemRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			LOG.error("Error: Failed to delete food item from DB for Id=" + id, e);
			return false;
		}
	}

}
