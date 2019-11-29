package com.indhawk.getfiteat.foods.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indhawk.getfiteat.foods.model.FoodCategoryModel;
import com.indhawk.getfiteat.foods.mongodb.dataobj.FoodCategoryDO;
import com.indhawk.getfiteat.foods.mongodb.repository.FoodCategoryRepository;
import com.indhawk.getfiteat.foods.request.FoodCategoryRequest;

@Service(value = "foodCategoryService")
public class FoodCategoryService {

	private static final Logger LOG = LoggerFactory.getLogger(FoodCategoryService.class);

	@Autowired
	private FoodCategoryRepository foodCategoryRepository;

	public boolean saveFoodCategory(FoodCategoryRequest request) {
		FoodCategoryDO foodCategoryDo = new FoodCategoryDO();
		try {
			BeanUtils.copyProperties(request, foodCategoryDo);
			FoodCategoryDO result = foodCategoryRepository.save(foodCategoryDo);
			if (result != null) return true;
			else return false;
		} catch (Exception e) {
			LOG.error("Error: Failed to save new food categroy in DB.", e);
			return false;
		}
	}
	
	public List<FoodCategoryModel> getFoodCategories() {
		List<FoodCategoryModel> foodCatModelList = new ArrayList<>();
		List<FoodCategoryDO> foodCatDoList = foodCategoryRepository.findAll();
		foodCatDoList.stream().forEach(t -> {
			FoodCategoryModel m = new FoodCategoryModel();
			BeanUtils.copyProperties(t, m);
			foodCatModelList.add(m);
		});
		return foodCatModelList;
	}
	
	public FoodCategoryModel getFoodCategoryById(String catId) {
		FoodCategoryDO FoodCatDO = foodCategoryRepository.getFoodCategoryByCatId(catId);
		FoodCategoryModel model = new FoodCategoryModel();
		BeanUtils.copyProperties(FoodCatDO, model);
		return model;
	}
	
	public boolean deleteFoodCategory(String catId) {
		try {
			foodCategoryRepository.deleteById(catId);
			return true;
		} catch (Exception e) {
			LOG.error("Error: Failed to delete food category=" + catId+ " from DB.", e);
			return false;
		}
	}

}
