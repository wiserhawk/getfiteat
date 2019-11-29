package com.indhawk.getfiteat.vendor.manager.response;

import com.indhawk.getfiteat.vendor.manager.model.VendorModel;

public class VendorAuthResponse {
	
	private boolean authentication;
	
	private VendorModel vendorInfo;

	public VendorAuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isAuthentication() {
		return authentication;
	}

	public void setAuthentication(boolean authentication) {
		this.authentication = authentication;
	}

	public VendorModel getVendorInfo() {
		return vendorInfo;
	}

	public void setVendorInfo(VendorModel vendorInfo) {
		this.vendorInfo = vendorInfo;
	}

	@Override
	public String toString() {
		return "VendorAuthResponse [authentication=" + authentication + ", vendorInfo=" + vendorInfo + "]";
	}
	
	 

}
