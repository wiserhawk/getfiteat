package com.indhawk.auth.sync.restclient;

import com.indhawk.auth.model.UserInfoModel;

public class UserAuthRespose {
	
	private boolean authentication;
	
	private UserInfoModel userInfo;

	public UserAuthRespose() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAuthRespose(boolean authentication, UserInfoModel userInfo) {
		super();
		this.authentication = authentication;
		this.userInfo = userInfo;
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
		return "UserAuthRespose [authentication=" + authentication + ", userInfo=" + userInfo + "]";
	}
	
	

}
