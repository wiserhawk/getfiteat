package com.indhawk.auth.response;

import com.indhawk.auth.model.UserInfoModel;

public class UserLoginResponse implements Response {

	/**
	 * This JWT signature token to authenticate user request for each secured API calls.
	 */
	private String token;
	
	private boolean authentication;
	
	private UserInfoModel userInfo;

	public UserLoginResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isAuthentication() {
		return authentication;
	}

	public void setAuthentication(boolean authentication) {
		this.authentication = authentication;
	}

	public UserInfoModel getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfoModel userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public String toString() {
		return "UserLoginResponse [token=" + token + ", authentication=" + authentication + ", userInfo=" + userInfo
				+ "]";
	}

}
