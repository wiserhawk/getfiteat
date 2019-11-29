package com.indhawk.getfiteat.user.manager.request;

public class LoginRequest {
	
	private String identifier;
	
	private String password;

	public LoginRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginRequest [identifier=" + identifier + ", password=" + password + "]";
	}
	
	

}
