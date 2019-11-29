package com.indhawk.api.gateway.auth.request;

public class LoginRequest {
	
	/**
	 * loginId could be email/phone 
	 */
	private String loginId;
	
	private String password;

	public LoginRequest() {
		super();
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginRequest [loginId=" + loginId + ", password=" + password + "]";
	}

}
