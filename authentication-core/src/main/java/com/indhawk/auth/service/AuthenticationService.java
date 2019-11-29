package com.indhawk.auth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.indhawk.auth.async.events.publisher.EventPublisher;
import com.indhawk.auth.jwt.JwtTokenGenerator;
import com.indhawk.auth.model.Auth;
import com.indhawk.auth.request.LoginRequest;
import com.indhawk.auth.response.UserLoginResponse;
import com.indhawk.auth.sync.restclient.RestClient;
import com.indhawk.auth.sync.restclient.UserAuthRespose;

@Service
public class AuthenticationService {

	private static final Logger LOG = LoggerFactory.getLogger(AuthenticationService.class);
	
	@Autowired
	@Qualifier("restClientSpringBootTemplate")
	private RestClient restClient;
	
	/*@Autowired
	private EventPublisher eventPublisher;*/
	
	public UserLoginResponse authencateUser(LoginRequest request) {
		UserLoginResponse response = new UserLoginResponse();
		UserAuthRespose authRes = restClient.authenticateUser(request.getLoginId(), request.getPassword());
		if (authRes.isAuthentication()) {
			String jwtToken = JwtTokenGenerator.generateJwtToken(authRes.getUserInfo().getUserId());
			response.setAuthentication(true);
			response.setToken(jwtToken);
			response.setUserInfo(authRes.getUserInfo());
			return response;
		} 
		response.setAuthentication(false);
		return response;
	}
	
	/*public UserLoginResponse asyncAuthencateUser(LoginRequest request) {
		Auth auth = new Auth(request.getLoginId(), request.getPassword());
		eventPublisher.publish(auth);
		return null;
	}*/
	
	
}
