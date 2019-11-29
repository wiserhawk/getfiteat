package com.indhawk.getfiteat.user.manager.response;

public class UserDetailResponse {
	
	private String userId;
	
	private String name;
	
	private String phone;
	
	private String email;

	public UserDetailResponse() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "UserDetailResponse [userId=" + userId + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ "]";
	}


}
