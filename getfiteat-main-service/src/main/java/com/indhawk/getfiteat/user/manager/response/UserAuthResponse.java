package com.indhawk.getfiteat.user.manager.response;

import com.indhawk.getfiteat.user.manager.model.UserDetailModel;

public class UserAuthResponse {
	
	private boolean authentication;
	
	private UserDetailModel userInfo;

	public UserAuthResponse() {
		super();
	}

	public UserAuthResponse(boolean authentication, UserDetailModel userInfo) {
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

	public UserDetailModel getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserDetailModel userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public String toString() {
		return "UserAuthResponse [authentication=" + authentication + ", userInfo=" + userInfo + "]";
	}
	
}
