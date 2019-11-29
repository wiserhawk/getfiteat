package com.indhawk.vendor.manager.util;

import java.util.regex.Pattern;

public class FormatUtil {
	
	public static boolean isNumber(String number) {
		boolean isNumber = false;
		try {
            Double.parseDouble(number);
            isNumber = true;
        } catch (NumberFormatException e) {
        	isNumber = false;
        }
		return isNumber;
	}
	
	public static boolean isValidEmailId(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$"; 
                  
		Pattern pat = Pattern.compile(emailRegex); 
		if (email == null) 
		return false; 
		return pat.matcher(email).matches(); 
	}

}
