package com.indhawk.getfiteat.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.indhawk.getfiteat.order.dataobj.InvoiceNumberDO;

@Repository
public interface InvoiceNumberRepository extends MongoRepository<InvoiceNumberDO, Long> {

	public InvoiceNumberDO findTopByOrderByInvoiceNumberDesc();
	
	public InvoiceNumberDO findFirstByOrderByInvoiceNumberDesc();
	
}
