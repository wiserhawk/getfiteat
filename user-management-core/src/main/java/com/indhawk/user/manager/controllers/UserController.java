package com.indhawk.user.manager.controllers;

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

import com.indhawk.user.manager.facade.AddressManagerFacade;
import com.indhawk.user.manager.facade.UserManagerFacade;
import com.indhawk.user.manager.request.AddressRequest;
import com.indhawk.user.manager.request.UserDetailRequest;
import com.indhawk.user.manager.response.AddressResponse;
import com.indhawk.user.manager.response.UserAuthResponse;
import com.indhawk.user.manager.response.UserDetailResponse;
import com.indhawk.user.manager.validator.AddressRequestValidator;
import com.indhawk.user.manager.validator.RequestValidator;

@RestController
public class UserController {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserManagerFacade userManagerFacade;
	
	@Autowired
	private AddressManagerFacade addressManagerFacade;
	
	@Autowired
	@Qualifier("userDetailRequestValidator")
	private RequestValidator requestValidator;
	
	@Autowired
	@Qualifier("addressRequestValidator")
	private AddressRequestValidator addressRequestValidator;
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/user-manager/userAccount/create", method = RequestMethod.POST)
	public ResponseEntity<Object> createUserAccount(@RequestBody UserDetailRequest request) {
		try { 
			requestValidator.validate(request);
		} catch (Exception e) {
			LOG.error("ERROR: {}", e.getMessage(), e);
			ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
			return errorRespnose;
		}
		
		try {
			long startTime = System.currentTimeMillis();
			UserDetailResponse userInfo = userManagerFacade.createUserAccount(request);
			long endTime = System.currentTimeMillis();
			ResponseEntity<Object> respnose = new ResponseEntity<Object>(userInfo, HttpStatus.OK);
			LOG.info("URL /user-manager/userAccount/create time taken = {}", (endTime - startTime));
			return respnose;
		} catch(Exception e) {
			LOG.error(e.getMessage());
			ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			return errorRespnose;
		}
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/user-manager/userDetailByEmail/get", method = RequestMethod.POST)
	public ResponseEntity<Object> getUserDetailByEmail(String email) {
		try {
			if (!StringUtils.isEmpty(email)) {
				long startTime = System.currentTimeMillis();
				UserDetailResponse userInfo = userManagerFacade.getUserDetailByEmail(email);
				long endTime = System.currentTimeMillis();
				ResponseEntity<Object> respnose = new ResponseEntity<Object>(userInfo, HttpStatus.OK);
				LOG.info("URL /user-manager/userDetailByEmail/get time taken = {}", (endTime - startTime));
				return respnose;
			} else {
				LOG.error("ERROR: Input Email is not available. Email={}", email);
				ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>("Email parameter is either null or empty.", HttpStatus.BAD_REQUEST);
				return errorRespnose;
			}
		} catch(Exception e) {
			LOG.error(e.getMessage());
			ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			return errorRespnose;
		}
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/user-manager/userDetailByPhone/get", method = RequestMethod.POST)
	public ResponseEntity<Object> getUserDetailByPhone(String phone) {
		try {
			if (!StringUtils.isEmpty(phone)) {
				long startTime = System.currentTimeMillis();
				UserDetailResponse userInfo = userManagerFacade.getUserDetailByPhone(phone);
				long endTime = System.currentTimeMillis();
				ResponseEntity<Object> respnose = new ResponseEntity<Object>(userInfo, HttpStatus.OK);
				LOG.info("URL /user-manager/userDetailByPhone/get time taken = {}", (endTime - startTime));
				return respnose;
			} else {
				LOG.error("ERROR: Input Phone is not available. Phone={}", phone);
				ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>("Phone parameter is either null or empty.", HttpStatus.BAD_REQUEST);
				return errorRespnose;
			}
		} catch(Exception e) {
			LOG.error(e.getMessage());
			ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			return errorRespnose;
		}
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/user-manager/userDetailByUserId/get", method = RequestMethod.POST)
	public ResponseEntity<Object> getUserDetailByUserId(String userId) {
		try {
			if (!StringUtils.isEmpty(userId)) {
				long startTime = System.currentTimeMillis();
				UserDetailResponse userInfo = userManagerFacade.getUserDetailByUserId(userId);
				long endTime = System.currentTimeMillis();
				ResponseEntity<Object> respnose = new ResponseEntity<Object>(userInfo, HttpStatus.OK);
				LOG.info("URL /user-manager/userDetailByUserId/get time taken = {}", (endTime - startTime));
				return respnose;
			} else {
				LOG.error("ERROR: Input UserID is not available. UserId={}", userId);
				ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>("User ID parameter is either null or empty.", HttpStatus.BAD_REQUEST);
				return errorRespnose;
			}
		} catch(Exception e) {
			LOG.error(e.getMessage());
			ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			return errorRespnose;
		}
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/user-manager/userAddress/create", method = RequestMethod.POST)
	public ResponseEntity<Object> createUserAddress(@RequestBody AddressRequest address) {
		try { 
			addressRequestValidator.validate(address);
		} catch (Exception e) {
			LOG.error("ERROR: {}", e.getMessage(), e);
			ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
			return errorRespnose;
		}
		
		try {
			long startTime = System.currentTimeMillis();
			AddressResponse addressResponse = addressManagerFacade.createUserAddress(address);
			long endTime = System.currentTimeMillis();
			ResponseEntity<Object> respnose = new ResponseEntity<Object>(addressResponse, HttpStatus.OK);
			LOG.info("URL /user-manager/userAddress/create time taken = {}", (endTime - startTime));
			return respnose;
		} catch(Exception e) {
			LOG.error(e.getMessage());
			ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			return errorRespnose;
		}
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/user-manager/addressDetailsByUserId/get", method = RequestMethod.POST)
	public ResponseEntity<Object> getAddressDetailsByUserId(String userId) {
		try {
			if (!StringUtils.isEmpty(userId)) {
				long startTime = System.currentTimeMillis();
				List<AddressResponse> addressDetails = addressManagerFacade.getAddressDetailsByUserId(userId);
				long endTime = System.currentTimeMillis();
				ResponseEntity<Object> respnose = new ResponseEntity<Object>(addressDetails, HttpStatus.OK);
				LOG.info("URL /user-manager/addressDetailsByUserId/get time taken = {}", (endTime - startTime));
				return respnose;
			} else {
				LOG.error("ERROR: Input UserID is not available. UserId={}", userId);
				ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>("User ID parameter is either null or empty.", HttpStatus.BAD_REQUEST);
				return errorRespnose;
			}
		} catch(Exception e) {
			LOG.error(e.getMessage());
			ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			return errorRespnose;
		}
	}
	
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/user-manager/addressDetailsByAddressNumber/get", method = RequestMethod.POST)
	public ResponseEntity<Object> getAddressDetailByAddressNumber(String addressNumber) {
		try {
			if (!StringUtils.isEmpty(addressNumber)) {
				long startTime = System.currentTimeMillis();
				AddressResponse addressDetail = addressManagerFacade.getAddressDetailsByAddressNum(addressNumber);
				long endTime = System.currentTimeMillis();
				ResponseEntity<Object> respnose = new ResponseEntity<Object>(addressDetail, HttpStatus.OK);
				LOG.info("URL /user-manager/addressDetailsByAddressNumber/get time taken = {}", (endTime - startTime));
				return respnose;
			} else {
				LOG.error("ERROR: Input addressNumber is not available. addressNumber={}", addressNumber);
				ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>("AddressNumber parameter is either null or empty.", HttpStatus.BAD_REQUEST);
				return errorRespnose;
			}
		} catch(Exception e) {
			LOG.error(e.getMessage());
			ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			return errorRespnose;
		}
	}
	
	/**
	 * Return authentication status {@code true/false } based of credential provided.
	 * {@code identifier} either will be email id or phone number. 
	 * @param identifier Either will be email id or phone number. 
	 * @param password un-encrypted password.
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/user-manager/authenticate", method = RequestMethod.POST)
	public ResponseEntity<Object> authenticateUser(String identifier, String password) {
		try {
			if (!StringUtils.isEmpty(identifier) && !StringUtils.isEmpty(password) ) {
				long startTime = System.currentTimeMillis();
				UserAuthResponse authResponse = userManagerFacade.authenticate(identifier, password);
				long endTime = System.currentTimeMillis();
				ResponseEntity<Object> respnose = new ResponseEntity<Object>(authResponse, HttpStatus.OK);
				LOG.info("URL /user-manager/authenticate time taken = {}", (endTime - startTime));
				return respnose;
			} else {
				LOG.error("ERROR: Input identifier / password is not available. identifier={}, is_password_empty={}", identifier, StringUtils.isEmpty(password));
				ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>("Input identifier / password is either null or empty.", HttpStatus.BAD_REQUEST);
				return errorRespnose;
			}
		} catch(Exception e) {
			LOG.error(e.getMessage());
			ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			return errorRespnose;
		}
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/user-manager/sendVerificationCodeOnEmail", method = RequestMethod.POST)
	public ResponseEntity<Object> sendVerificationCodeOnEmail(String email) {
		try {
			if (!StringUtils.isEmpty(email)) {
				long startTime = System.currentTimeMillis();
				String message = userManagerFacade.sendVerificationCodeOnEmail(email);
				long endTime = System.currentTimeMillis();
				ResponseEntity<Object> respnose = new ResponseEntity<Object>(message, HttpStatus.OK);
				LOG.info("URL /user-manager/sendVerificationCodeOnEmail time taken = {}", (endTime - startTime));
				return respnose;
			} else {
				LOG.error("ERROR: Input email is not available.");
				ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>("Input email is either null or empty.", HttpStatus.BAD_REQUEST);
				return errorRespnose;
			}
		} catch(Exception e) {
			LOG.error(e.getMessage());
			ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			return errorRespnose;
		}
	}
	
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/user-manager/resetUserPassword", method = RequestMethod.POST)
	public ResponseEntity<Object> resetUserPassword(String email, String password, String verificationCode) {
		try {
			if (!StringUtils.isEmpty(email) && !StringUtils.isEmpty(password) && !StringUtils.isEmpty(verificationCode)) {
				long startTime = System.currentTimeMillis();
				String message = userManagerFacade.resetUserPassword(email, password, verificationCode);
				long endTime = System.currentTimeMillis();
				ResponseEntity<Object> respnose = new ResponseEntity<Object>(message, HttpStatus.OK);
				LOG.info("URL /user-manager/resetUserPassword time taken = {}", (endTime - startTime));
				return respnose;
			} else {
				LOG.error("ERROR: Input email / password / verification-code is not available. eamil={}, password={}, verifcation-code={}", email, password, verificationCode);
				ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>("Input email / password / verification-code is either null or empty.", HttpStatus.BAD_REQUEST);
				return errorRespnose;
			}
		} catch(Exception e) {
			LOG.error(e.getMessage());
			ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			return errorRespnose;
		}
	}

}
