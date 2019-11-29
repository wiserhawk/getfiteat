package com.indhawk.api.gateway.user.request;

public class AddressRequest {
	
private String userId;
	
	private String addressType;
	
	private String street;
	
	private String area;
	
	private String state;
	
	private String pincode;
	
	private String phone;

	public AddressRequest() {
		super();
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "AddressRequest [userId=" + userId + ", addressType=" + addressType + ", street=" + street + ", area="
				+ area + ", state=" + state + ", pincode=" + pincode + ", phone=" + phone + "]";
	}
	

}
