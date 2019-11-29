package com.indhawk.api.gateway.auth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.indhawk.api.gateway.auth.request.LoginRequest;
import com.indhawk.api.gateway.restclient.AuthenticationServiceRestClient;

@RestController
public class AuthenticationGatewayController {
	
	private static final Logger LOG = LoggerFactory.getLogger(AuthenticationGatewayController.class); 
	
	@Autowired
	@Qualifier("authenticationServiceRestClientImpl")
	private AuthenticationServiceRestClient authenticationServiceRestClient;
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/api-gateway/auth/authenticateUser", method = RequestMethod.POST)
	public ResponseEntity<Object> authenticateUser(@RequestBody LoginRequest credential) {
		ResponseEntity<Object> response = authenticationServiceRestClient.authenticateUser(credential);
		return response;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/api-gateway/auth/authenticateVendor", method = RequestMethod.POST)
	public ResponseEntity<Object> authenticateVendor(@RequestBody LoginRequest credential) {
		ResponseEntity<Object> response = authenticationServiceRestClient.authenticateVendor(credential);
		return response;
	}

}
