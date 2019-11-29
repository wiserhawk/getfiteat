package com.indhawk.foods.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.indhawk.foods.mongodb.dataobj.FoodCategoryDO;

public interface FoodCategoryRepository extends MongoRepository<FoodCategoryDO, String> {
	
	public FoodCategoryDO getFoodCategoryByCatId(String catId);

}
