package com.indhawk.getfiteat.foods.response;

public abstract class GenericResponse implements RestResponse {
	
	long exectionTime;
	
	@Override
	public long executionTime() {
		return exectionTime;
	}
	
	public void setExecutionTime(long time) {
		this.exectionTime = time;
	}

}
