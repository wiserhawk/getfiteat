package com.indhawk.billing.gst;

public class GSTDetails {
	
	private GSTProductType productType;
	
	private float gst;
	
	private float cgst;
	
	private float sgst;
	

	public GSTDetails(GSTProductType productType, float gst, float cgst, float sgst) {
		super();
		this.productType = productType;
		this.gst = gst;
		this.cgst = cgst;
		this.sgst = sgst;
	}

	public GSTDetails() {
		super();
	}

	public GSTProductType getProductType() {
		return productType;
	}

	public void setProductType(GSTProductType productType) {
		this.productType = productType;
	}

	public float getGst() {
		return gst;
	}

	public void setGst(float gst) {
		this.gst = gst;
	}

	public float getCgst() {
		return cgst;
	}

	public void setCgst(float cgst) {
		this.cgst = cgst;
	}

	public float getSgst() {
		return sgst;
	}

	public void setSgst(float sgst) {
		this.sgst = sgst;
	}

	@Override
	public String toString() {
		return "GSTDetails [productType=" + productType + ", gst=" + gst + "%, cgst=" + cgst + "%, sgst=" + sgst + "%]";
	}
	
	

}
