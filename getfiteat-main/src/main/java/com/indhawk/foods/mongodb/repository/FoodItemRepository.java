package com.indhawk.foods.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.indhawk.foods.mongodb.dataobj.FoodItemDO;

@Repository
public interface FoodItemRepository extends MongoRepository<FoodItemDO, String> {

	
	public List<FoodItemDO> getFoodItemsByCategoryId(String categoryId);
	
	public List<FoodItemDO> getFoodItemsByTypeId(String typeId);
	
	public List<FoodItemDO> getFoodItemsByType(String type);
	
	public  List<FoodItemDO> getFoodItemsByCategory(String category);
	
	public List<FoodItemDO> getFoodItemsByMenu(String menu);
	
	
}
