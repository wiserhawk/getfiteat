package com.indhawk.auth.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.indhawk.auth.request.LoginRequest;
import com.indhawk.auth.response.UserLoginResponse;
import com.indhawk.auth.service.AuthenticationService;

@Component
public class AuthenticationFacade {
	
	private static final Logger LOG = LoggerFactory.getLogger(AuthenticationFacade.class);
	
	@Autowired
	private AuthenticationService authenticationService;
	
	public UserLoginResponse authencateUser(LoginRequest request) {
		return authenticationService.authencateUser(request);
	}

}
