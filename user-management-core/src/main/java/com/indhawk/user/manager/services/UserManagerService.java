package com.indhawk.user.manager.services;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indhawk.user.manager.model.UserDetailModel;
import com.indhawk.user.manager.mongodb.dataobj.UserDetailDO;
import com.indhawk.user.manager.mongodb.repository.UserDetailRepository;
import com.indhawk.user.manager.request.UserDetailRequest;
import com.indhawk.user.manager.response.UserAuthResponse;
import com.indhawk.user.manager.util.Encryptor;
import com.indhawk.user.manager.util.FormatUtil;

@Service
public class UserManagerService {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserManagerService.class);
	
	@Autowired
	private UserDetailRepository userDetailRepository;
	
	private static final String USER_ID_PREFIX = "USR";
	
	private static final int INITIAL_USER_ID_NUMBER = 1;
	
	public UserDetailModel createUserAccount(UserDetailRequest request) {
		LOG.debug("Creating new user={}", request);
		String userId = getNextUserId();
		UserDetailDO userDetailDO = new UserDetailDO();
		BeanUtils.copyProperties(request, userDetailDO);
		userDetailDO.setUserId(userId);
		userDetailDO.setPassword(Encryptor.encrypt(request.getPassword()));
		UserDetailDO finalUserDetail = userDetailRepository.save(userDetailDO);
		UserDetailModel userDetailModel =  new UserDetailModel();
		BeanUtils.copyProperties(finalUserDetail, userDetailModel);
		LOG.debug("User successfully created. user={}", userDetailModel);
		return userDetailModel;
	}
	
	public UserDetailModel getUserDetailByEmail(String email) {
		LOG.debug("Getting user detail by eamil={}", email);
		List<UserDetailDO> userDetailList = userDetailRepository.getUserDetailsByEmail(email);
		UserDetailDO userDetail = (userDetailList == null || userDetailList.isEmpty()) ? null : userDetailList.get(0);
		if (userDetail == null) {
			throw new RuntimeException("User details not found for email=" + email);
		}
		UserDetailModel userDetailModel = new UserDetailModel();
		BeanUtils.copyProperties(userDetail, userDetailModel);
		LOG.debug("Fetched userDetail={} for eamil={}", userDetailModel, email);
		return userDetailModel;
	}
	
	public UserDetailModel getUserDetailByPhone(String phone) {
		LOG.debug("Getting user detail by phone={}", phone);
		List<UserDetailDO> userDetailList = userDetailRepository.getUserDetailsByPhone(phone);
		UserDetailDO userDetail = (userDetailList == null || userDetailList.isEmpty()) ? null : userDetailList.get(0);
		if (userDetail == null) {
			throw new RuntimeException("User details not found for phone=" + phone);
		}
		UserDetailModel userDetailModel = new UserDetailModel();
		BeanUtils.copyProperties(userDetail, userDetailModel);
		LOG.debug("Fetched userDetail={} for phone={}", userDetailModel, phone);
		return userDetailModel;
	}
	
	public UserDetailModel getUserDetailByUserId(String userId) {
		LOG.debug("Getting user detail by userId={}", userId);
		UserDetailDO userDetail = userDetailRepository.getUserDetailByUserId(userId);
		if (userDetail == null) {
			throw new RuntimeException("User details not found for userId=" + userId);
		}
		UserDetailModel userDetailModel = new UserDetailModel();
		BeanUtils.copyProperties(userDetail, userDetailModel);
		LOG.debug("Fetched userDetail={} for userId={}", userDetailModel, userId);
		return userDetailModel;
	}
	
	public UserAuthResponse authenticate(String identifier, String password) {
		LOG.debug("Authenticating identifier={}", identifier);
		UserAuthResponse authResponse = new UserAuthResponse();
		
		boolean isAnEmail = FormatUtil.isValidEmailId(identifier);
		if (isAnEmail) {
			UserDetailModel model = getUserDetailByEmail(identifier);
			if (model != null) {
				String encryptPwd = Encryptor.encrypt(password);
				if (model.getPassword().equals(encryptPwd)) {
					model.setPassword("**************");
					authResponse.setAuthentication(true);
					authResponse.setUserInfo(model);
					return authResponse;
				}
			}
			authResponse.setAuthentication(false);
			return authResponse;
		}
		
		boolean isAPhone = FormatUtil.isNumber(identifier);
		if (isAPhone) {
			UserDetailModel model = getUserDetailByPhone(identifier);
			if (model != null) {
				String encryptPwd = Encryptor.encrypt(password);
				if (model.getPassword().equals(encryptPwd)) {
					model.setPassword("**************");
					authResponse.setAuthentication(true);
					authResponse.setUserInfo(model);
					return authResponse;
				}
			}
			authResponse.setAuthentication(false);
			return authResponse;
		}
		authResponse.setAuthentication(false);
		return authResponse;
		
	}
	
	public String sendVerificationCodeOnEmail(String email) {
		try {
			UserDetailModel userModel = getUserDetailByEmail(email);
			String userId = userModel.getUserId();
			String code = generateVerificationCode(userId);
			
			//TODO send Code in email on given email id;
			
			return "Verification code has been sent to your email id " + email;
		} catch (Exception e) {
			LOG.error("Failed to send verification code on email to reset user password.", e);
			return "ERROR: Failed to send verification code of email.";
		}
	}
	
	public String resetUserPassword(String email, String password, String verificationCode) {
		try {
			UserDetailModel userModel = getUserDetailByEmail(email);
			String userId = userModel.getUserId();
			String code = generateVerificationCode(userId);
			if (code.equals(verificationCode)) {
				String encodedPwd = Encryptor.encrypt(password);
				userModel.setPassword(encodedPwd);
				UserDetailDO userDetailDO = new UserDetailDO();
				BeanUtils.copyProperties(userModel, userDetailDO);
				userDetailRepository.save(userDetailDO);
			}
			return "New password successfully updated.";
		} catch (Exception e) {
			LOG.error("Failed to reset password for user={}", email);
			return "ERROR: User reset password operation failed";
		}

	}
	
	public String getNextUserId() {
		UserDetailDO userDetail = userDetailRepository.findTopByOrderByUserIdDesc();
		String nextUserId = null;
		String currentId = null;
		if (userDetail != null) {
			currentId = userDetail.getUserId();
			int nextId = Integer.parseInt(currentId.substring(3)) + 1;
			nextUserId = USER_ID_PREFIX + nextId;
		} else {
			nextUserId = USER_ID_PREFIX + INITIAL_USER_ID_NUMBER;
		}
		return nextUserId;
	}
	
	public boolean isPhoneNumberExist(String phone) {
		List<UserDetailDO> userDetails = userDetailRepository.getUserDetailsByPhone(phone);
		if (userDetails == null || userDetails.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public boolean isEmailExist(String email) {
		List<UserDetailDO> userDetails = userDetailRepository.getUserDetailsByEmail(email);
		if (userDetails == null || userDetails.isEmpty()) {
			return false;
		}
		return true;
	}
	
	private String generateVerificationCode(String userId) {
		StringBuilder sb = new StringBuilder("Z"); 
		for(int i = userId.length() - 1; i >= 0; i--)
        {
            sb.append(userId.charAt(i));
        }
		sb.append("T");
		return sb.toString().toUpperCase();
	}

}
