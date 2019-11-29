package com.indhawk.foods.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.indhawk.foods.mongodb.dataobj.FoodCategoryDO;

@Repository
public interface FoodCategoryRepository extends MongoRepository<FoodCategoryDO, String> {
	
	public FoodCategoryDO getFoodCategoryByCatId(String catId);

}
