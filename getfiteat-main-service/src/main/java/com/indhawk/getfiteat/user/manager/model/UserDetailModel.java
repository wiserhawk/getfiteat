package com.indhawk.getfiteat.user.manager.model;

public class UserDetailModel {
	
	private String userId;
	
	private String name;
	
	private String phone;
	
	private String email;
	
	private String password;

	public UserDetailModel() {
		super();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDetailModel [userId=" + userId + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", password=" + password + "]";
	}
	

}

