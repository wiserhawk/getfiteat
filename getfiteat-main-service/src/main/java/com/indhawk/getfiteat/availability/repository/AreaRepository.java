package com.indhawk.getfiteat.availability.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.indhawk.getfiteat.availability.dataobj.AreaDO;



public interface AreaRepository extends MongoRepository<AreaDO, String> {
	
	public List<AreaDO> getAreasByPincode(String pincode);

}
