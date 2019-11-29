package com.indhawk.user.manager.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.indhawk.user.manager.mongodb.dataobj.AddressDetailDO;

@Repository
public interface AddressDetailRepository extends MongoRepository<AddressDetailDO, String> {
	
	public AddressDetailDO findTopByOrderByAddressNumDesc();
	
	public List<AddressDetailDO> getAddressDetailsByUserId(String userId);
	
	public AddressDetailDO getAddressDetailByAddressNum(String addressNum);

}
