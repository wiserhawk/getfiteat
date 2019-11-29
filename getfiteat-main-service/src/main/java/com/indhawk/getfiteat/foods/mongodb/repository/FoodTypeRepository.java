package com.indhawk.getfiteat.foods.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.indhawk.getfiteat.foods.mongodb.dataobj.FoodTypeDO;

@Repository
public interface FoodTypeRepository extends MongoRepository<FoodTypeDO, String>{
	
	public FoodTypeDO getFoodTypeByTypeId(String typeId);

}
