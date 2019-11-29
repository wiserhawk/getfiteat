package com.indhawk.user.manager.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.indhawk.user.manager.mongodb.dataobj.UserDetailDO;

@Repository
public interface UserDetailRepository extends MongoRepository<UserDetailDO, String> {
	
	public UserDetailDO findTopByOrderByUserIdDesc();
	
	public List<UserDetailDO> getUserDetailsByPhone(String phone);
	
	public List<UserDetailDO> getUserDetailsByEmail(String email);
	
	public UserDetailDO getUserDetailByUserId(String userId);
	
}
