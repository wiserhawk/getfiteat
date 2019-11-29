package com.indhawk.api.gateway.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.indhawk.api.gateway.restclient.UserServiceRestClient;
import com.indhawk.api.gateway.user.request.AddressRequest;
import com.indhawk.api.gateway.user.request.UserDetailRequest;



@RestController
public class UserGatewayController {
	
	@Autowired
	@Qualifier("userServiceRestClientImpl")
	private UserServiceRestClient userServiceRestClient;
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/api-gateway/users/userAccount/create", method = RequestMethod.POST)
	public ResponseEntity<Object> createUserAccount(@RequestBody UserDetailRequest request) {
		ResponseEntity<Object> response = userServiceRestClient.createUserAccount(request);
		return response;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/api-gateway/users/userDetailByEmail/get", method = RequestMethod.POST)
	public ResponseEntity<Object> getUserDetailByEmail(String email) {
		ResponseEntity<Object> response = userServiceRestClient.getUserDetailByEmail(email);
		return response;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/api-gateway/users/userDetailByPhone/get", method = RequestMethod.POST)
	public ResponseEntity<Object> getUserDetailByPhone(String phone) {
		ResponseEntity<Object> response = userServiceRestClient.getUserDetailByPhone(phone);
		return response;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/api-gateway/users/userDetailByUserId/get", method = RequestMethod.POST)
	public ResponseEntity<Object> getUserDetailByUserId(String userId) {
		ResponseEntity<Object> response = userServiceRestClient.getUserDetailByUserId(userId);
		return response;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/api-gateway/users/userAddress/create", method = RequestMethod.POST)
	public ResponseEntity<Object> createUserAddress(@RequestBody AddressRequest address) {
		ResponseEntity<Object> response = userServiceRestClient.createUserAddress(address);
		return response;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/api-gateway/users/addressDetailsByUserId/get", method = RequestMethod.POST)
	public ResponseEntity<Object> getAddressDetailsByUserId(String userId) {
		ResponseEntity<Object> response = userServiceRestClient.getAddressDetailsByUserId(userId);
		return response;
	}
	
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/api-gateway/users/addressDetailsByAddressNumber/get", method = RequestMethod.POST)
	public ResponseEntity<Object> getAddressDetailByAddressNumber(String addressNumber) {
		ResponseEntity<Object> response = userServiceRestClient.getAddressDetailByAddressNumber(addressNumber);
		return response;
	}
	
	/**
	 * Return authentication status {@code true/false } based of credential provided.
	 * {@code identifier} either will be email id or phone number. 
	 * @param identifier Either will be email id or phone number. 
	 * @param password un-encrypted password.
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/api-gateway/users/authenticate", method = RequestMethod.POST)
	public ResponseEntity<Object> authenticateUser(String identifier, String password) {
		ResponseEntity<Object> response = userServiceRestClient.authenticateUser(identifier, password);
		return response;
	}

}
