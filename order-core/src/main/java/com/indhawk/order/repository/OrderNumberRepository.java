package com.indhawk.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.indhawk.order.dataobj.OrderNumberDO;

@Repository
public interface OrderNumberRepository extends MongoRepository<OrderNumberDO, Long>{
	
	
	public OrderNumberDO findTopByOrderByOrderNumberDesc();
	
	public OrderNumberDO findFirstByOrderByOrderNumberDesc();

}
