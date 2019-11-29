package com.indhawk.getfiteat.availability.request;

public class AreaRequest {

	private String areaId;
	
	private String state;
	
	private String district;
	
	private String area;
	
	private String pincode;

	public AreaRequest() {
		super();
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "AreaRequest [areaId=" + areaId + ", state=" + state + ", district=" + district + ", area=" + area
				+ ", pincode=" + pincode + "]";
	}

}
