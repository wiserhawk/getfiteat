package com.indhawk.getfiteat.billing.coupon;

import org.springframework.util.StringUtils;

public enum DiscountType {
	
	FLAT,
	PERCENTAGE;
	
	public static boolean isExists(String type) {
		if (StringUtils.isEmpty(type)) 
			return false;
		for (DiscountType t: values()) {
			if (t.name().equalsIgnoreCase(type))
				return true;
		}
		return false;
	}
	
	public static String getAllDiscountTypesAsString() {
		StringBuffer buffer = new StringBuffer();
		for (DiscountType t: values()) {
			buffer.append(t.name()).append(",");
		}
		return buffer.deleteCharAt(buffer.length() -1).toString();
	}

}
