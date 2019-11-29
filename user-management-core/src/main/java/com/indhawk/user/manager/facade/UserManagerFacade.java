package com.indhawk.user.manager.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.indhawk.user.manager.model.UserDetailModel;
import com.indhawk.user.manager.request.UserDetailRequest;
import com.indhawk.user.manager.response.UserAuthResponse;
import com.indhawk.user.manager.response.UserDetailResponse;
import com.indhawk.user.manager.services.UserManagerService;

@Component
public class UserManagerFacade {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserManagerFacade.class);
	
	@Autowired
	private UserManagerService userManagerService;
	
	public UserDetailResponse createUserAccount(UserDetailRequest request) {
		if (userManagerService.isEmailExist(request.getEmail())) {
			throw new RuntimeException("This email id is already used.");
		}
		if (userManagerService.isPhoneNumberExist(request.getPhone())) {
			throw new RuntimeException("This phone number is already used.");
		}
		try {
			UserDetailModel userDetailModel = userManagerService.createUserAccount(request);
			UserDetailResponse userDetailResponse = new UserDetailResponse();
			BeanUtils.copyProperties(userDetailModel, userDetailResponse);
			return userDetailResponse;
		} catch (Exception e) {
			LOG.error("Error: Failed to create user", e);
			throw new RuntimeException("Opps!!! Some error occured in server. please try again after sometime.");
		}
	}
	
	public UserDetailResponse getUserDetailByEmail(String email) {
		UserDetailModel model = userManagerService.getUserDetailByEmail(email);
		if (model != null) {
			UserDetailResponse response = new UserDetailResponse();
			BeanUtils.copyProperties(model, response);
			return response;
		}
		LOG.error("Error: User Detail for email={} in null", email);
		throw new RuntimeException("User Detail is not available for email=" + email);
	}

	public UserDetailResponse getUserDetailByPhone(String phone) {
		UserDetailModel model = userManagerService.getUserDetailByPhone(phone);
		if (model != null) {
			UserDetailResponse response = new UserDetailResponse();
			BeanUtils.copyProperties(model, response);
			return response;
		}
		LOG.error("Error: User Detail for phone={} in null", phone);
		throw new RuntimeException("User Detail is not available for phone=" + phone);
	}
	
	public UserDetailResponse getUserDetailByUserId(String userId) {
		UserDetailModel model = userManagerService.getUserDetailByUserId(userId);
		if (model != null) {
			UserDetailResponse response = new UserDetailResponse();
			BeanUtils.copyProperties(model, response);
			return response;
		}
		LOG.error("Error: User Detail for userId={} in null", userId);
		throw new RuntimeException("User Detail is not available for userId=" + userId);
	}
	
	public UserAuthResponse authenticate(String identifier, String password) {
		UserAuthResponse authResponse = userManagerService.authenticate(identifier, password);
		LOG.info("Authentication for identifier={} is {}", identifier, authResponse);
		return authResponse;
	}
	
	public String sendVerificationCodeOnEmail(String email) {
		return userManagerService.sendVerificationCodeOnEmail(email);
	}
	
	public String resetUserPassword(String email, String password, String verificationCode) {
		return userManagerService.resetUserPassword(email, password, verificationCode);
	}

}
