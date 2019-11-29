package com.indhawk.getfiteat.foods.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indhawk.getfiteat.foods.model.FoodTypeModel;
import com.indhawk.getfiteat.foods.mongodb.dataobj.FoodTypeDO;
import com.indhawk.getfiteat.foods.mongodb.repository.FoodTypeRepository;
import com.indhawk.getfiteat.foods.request.FoodTypeRequest;

@Service(value="foodTypeService")
public class FoodTypeService {
	
	private static final Logger LOG = LoggerFactory.getLogger(FoodTypeService.class);
	
	@Autowired
	private FoodTypeRepository foodTypeRepository;
	
	public boolean saveFoodType(FoodTypeRequest request) {
		FoodTypeDO foodTypeDo = new FoodTypeDO();
		try {
			BeanUtils.copyProperties(request, foodTypeDo);
			FoodTypeDO item = foodTypeRepository.save(foodTypeDo);
			if (item != null) return true;
			else return false;
		} catch (Exception e) {
			LOG.error("Error: Failed to save new food type in DB.", e);
			return false;
		}
	}
	
	public List<FoodTypeModel> getFoodTypes() {
		List<FoodTypeModel> foodTypeModelList = new ArrayList<>();
		List<FoodTypeDO> foodTypesDoList = foodTypeRepository.findAll();
		foodTypesDoList.stream().forEach(t -> {
			FoodTypeModel m = new FoodTypeModel();
			BeanUtils.copyProperties(t, m);
			foodTypeModelList.add(m);
		});
		return foodTypeModelList;
	}
	
    //    _._ _..._ .-',     _.._(`))
    //   '-. `     '  /-._.-'    ',/        RANDOM PIG
    //      )         \            '.       Well done, you have
    //     / _    _    |             \      found random pig.
    //    |  a    a    /              |
    //    \   .-.                     ;     It is now your
    //     '-('' ).-'       ,'       ;      responsibility to
    //        '-;           |      .'       insert random pig at
    //           \           \    /         another code location.
    //           | 7  .__  _.-\   \
    //           | |  |  ``/  /`  /         Don't ask me why, I don't
    //          /,_|  |   /,_/   /          make the rules around here.
    //             /,_/      '`-'
	
	public FoodTypeModel getFoodTypeById(String typeId) {
		FoodTypeDO FoodTypeDO = foodTypeRepository.getFoodTypeByTypeId(typeId);
		FoodTypeModel model = new FoodTypeModel();
		BeanUtils.copyProperties(FoodTypeDO, model);
		return model;
	}
	
	public boolean deleteFoodType(String typeId) {
		try {
			foodTypeRepository.deleteById(typeId);
			return true;
		} catch (Exception e) {
			LOG.error("Error: Failed to delete food type=" + typeId+ " from DB.", e);
			return false;
		}
	}

}
