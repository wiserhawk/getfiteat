package com.indhawk.getfiteat.payment.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.indhawk.getfiteat.payment.dataobj.PaymentDO;

@Repository
public interface PaymentRepository extends MongoRepository<PaymentDO, String>{
	
	public PaymentDO getPaymentByTxnId(String txnId);

}
