package com.indhawk.auth.model;

import java.io.Serializable;

public class Auth implements Serializable {
	
	private String identifier;
	
	private String password;
	
	public Auth() {
		super();
	}

	public Auth(String identifier, String password) {
		super();
		this.identifier = identifier;
		this.password = password;
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
		return "Auth [identifier=" + identifier + ", password=" + password + "]";
	}
	
}
