package com.indhawk.user.manager.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.indhawk.user.manager.request.Request;
import com.indhawk.user.manager.request.UserDetailRequest;
import com.indhawk.user.manager.util.FormatUtil;

@Component(value="userDetailRequestValidator")
public class UserDetailRequestValidator implements RequestValidator {

	@Override
	public boolean validate(Request request) {
		if (isRequestNotNull(request)) {
			UserDetailRequest r = (UserDetailRequest) request;
		    if (StringUtils.isEmpty(r.getName())) {
		    	throw new RuntimeException("User name cannot be null or empty.");
		    }
		    if (StringUtils.isEmpty(r.getPhone())) {
		    	throw new RuntimeException("Phone number cannot be null or empty.");
		    }
		    if (r.getPhone().length() != 10) {
		    	throw new RuntimeException("Phone number must be 10 digit long.");
		    }
		    if (!FormatUtil.isNumber(r.getPhone())) {
		    	throw new RuntimeException("Phone number must have all numeric characters.");
		    }
		    if (StringUtils.isEmpty(r.getEmail())) {
		    	throw new RuntimeException("Email cannot be null or empty.");
		    }
		    if (!FormatUtil.isValidEmailId(r.getEmail())) {
		    	throw new RuntimeException("Email format is not valid.");
		    }
		    if (StringUtils.isEmpty(r.getPassword())) {
		    	throw new RuntimeException("Password cannot be null or empty.");
		    }
		    if (r.getPassword().length() < 6) {
		    	throw new RuntimeException("Password lenght must be more than 6 digit.");
		    }
		    return true;
		}
		return false;
	}
	
	

}
