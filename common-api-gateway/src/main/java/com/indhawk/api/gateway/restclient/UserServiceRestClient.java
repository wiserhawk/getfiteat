package com.indhawk.api.gateway.restclient;

import org.springframework.http.ResponseEntity;

import com.indhawk.api.gateway.user.request.AddressRequest;
import com.indhawk.api.gateway.user.request.UserDetailRequest;

public interface UserServiceRestClient {
	
	String getRootURL();
	
	ResponseEntity<Object> createUserAccount(UserDetailRequest request);
	
	ResponseEntity<Object> getUserDetailByEmail(String email);
	
	ResponseEntity<Object> getUserDetailByPhone(String phone);
	
	ResponseEntity<Object> getUserDetailByUserId(String userId);
	
	ResponseEntity<Object> createUserAddress(AddressRequest address);
	
	ResponseEntity<Object> getAddressDetailsByUserId(String userId);
	
	ResponseEntity<Object> getAddressDetailByAddressNumber(String addressNumber);
	
	ResponseEntity<Object> authenticateUser(String identifier, String password);

}
