package com.indhawk.getfiteat.vendor.manager.response;

public class VendorDetailResponse {
	
	private String vendorId;
	
	private String vendorName;
	
	private String ownerName;
	
	private String contact;
	
	private String email;
	
	private String password;
	
	private String address;
	
	private String pincode;
	
	/**
	 * For Example = Malviya Nagar, Saket, Sector-21
	 */
	private String locality;
	
	private String district;
	
	private String state;
	
	/**
	 * Permanent Account Number
	 */
	private String pan;
	
	/**
	 * Company Identification Number
	 */
	private String cin;
	
	/**
	 * GST Identification Number
	 */
	private String gstin;
	
	private boolean isActive;

	public VendorDetailResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "VendorDetailResponse [vendorId=" + vendorId + ", vendorName=" + vendorName + ", ownerName=" + ownerName
				+ ", contact=" + contact + ", email=" + email + ", password=" + password + ", address=" + address
				+ ", pincode=" + pincode + ", locality=" + locality + ", district=" + district + ", state=" + state
				+ ", pan=" + pan + ", cin=" + cin + ", gstin=" + gstin + ", isActive=" + isActive + "]";
	}

	

}
