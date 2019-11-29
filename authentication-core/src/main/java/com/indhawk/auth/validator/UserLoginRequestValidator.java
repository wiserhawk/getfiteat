package com.indhawk.auth.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.indhawk.auth.request.LoginRequest;
import com.indhawk.auth.request.Request;

@Component("userLoginRequestValidator")
public class UserLoginRequestValidator implements RequestValidator {

	@Override
	public boolean validate(Request request) {
		if (isRequestNotNull(request)) {
			LoginRequest loginReq = (LoginRequest) request;
			if (StringUtils.isEmpty(loginReq.getLoginId())) {
				throw new RuntimeException("LoginId cannot be null or empty");
			}
			if (StringUtils.isEmpty(loginReq.getPassword())) {
				throw new RuntimeException("Password cannot be null or empty");
			}
			return true;
		}
		return false;
	}

}
