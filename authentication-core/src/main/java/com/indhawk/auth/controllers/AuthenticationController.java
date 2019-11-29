package com.indhawk.auth.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.indhawk.auth.facade.AuthenticationFacade;
import com.indhawk.auth.request.LoginRequest;
import com.indhawk.auth.response.UserLoginResponse;
import com.indhawk.auth.validator.RequestValidator;

@RestController
public class AuthenticationController {
	
	private static final Logger LOG = LoggerFactory.getLogger(AuthenticationController.class);
	
	@Autowired
	@Qualifier("userLoginRequestValidator")
	private RequestValidator userLoginRequestValidator;
	
	@Autowired
	private AuthenticationFacade authenticationFacade;
	
	/**
	 * This request mapper will fetch all food items and return it as response.
	 * 
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/auth-manager/authenticateUser", method = RequestMethod.POST)
	public ResponseEntity<Object> authenticateUser(@RequestBody LoginRequest credential) {
		try {
			userLoginRequestValidator.validate(credential);
		} catch (Exception e) {
			LOG.error("ERROR: {}", e.getMessage(), e);
			ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
			return errorRespnose;
		}
		
		try {
			long startTime = System.currentTimeMillis();
			UserLoginResponse userLoginRes = authenticationFacade.authencateUser(credential);
			long endTime = System.currentTimeMillis();
			ResponseEntity<Object> respnose = new ResponseEntity<Object>(userLoginRes, HttpStatus.OK);
			LOG.info("URL /auth-manager/authenticateUser time taken = {}", (endTime - startTime));
			return respnose;
		} catch(Exception e) {
			LOG.error(e.getMessage());
			ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			return errorRespnose;
		}
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/auth-manager/authenticateVendor", method = RequestMethod.POST)
	public ResponseEntity<Object> authenticateVendor(@RequestBody LoginRequest credential) {
		try {
			userLoginRequestValidator.validate(credential);
		} catch (Exception e) {
			LOG.error("ERROR: {}", e.getMessage(), e);
			ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
			return errorRespnose;
		}
		
		return null;
		
		/*try {
			long startTime = System.currentTimeMillis();
			UserLoginResponse userLoginRes = authenticationFacade.authencateUser(credential);
			long endTime = System.currentTimeMillis();
			ResponseEntity<Object> respnose = new ResponseEntity<Object>(userLoginRes, HttpStatus.OK);
			LOG.info("URL /auth-manager/authenticateUser time taken = {}", (endTime - startTime));
			return respnose;
		} catch(Exception e) {
			LOG.error(e.getMessage());
			ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			return errorRespnose;
		}*/
	}


}
