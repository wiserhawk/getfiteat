package com.indhawk.vendor.manager.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.indhawk.vendor.manager.dataobj.VendorDO;

@Repository
public interface VendorDetailsRepository extends MongoRepository<VendorDO, String>{
	
	public VendorDO findFirstByOrderByVendorIdDesc();
	
	public VendorDO getVendorByContact(String contact);
	
	public VendorDO getVendorByEmail(String email);
	
	public VendorDO getVendorByVendorId(String vendorId);
	
}
