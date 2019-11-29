package com.indhawk.api.gateway.restclient;

import org.springframework.http.ResponseEntity;

import com.indhawk.api.gateway.auth.request.LoginRequest;


public interface AuthenticationServiceRestClient {
	
	String getRootURL();
	
	ResponseEntity<Object> authenticateUser(LoginRequest credential);
	
	ResponseEntity<Object> authenticateVendor(LoginRequest credential);

}
