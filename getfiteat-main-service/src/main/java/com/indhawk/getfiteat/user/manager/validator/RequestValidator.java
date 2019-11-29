package com.indhawk.getfiteat.user.manager.validator;

import com.indhawk.getfiteat.user.manager.request.Request;

/**
 * This is an interface to validate any type of {@link Request}. Those
 * classes intend to validate any request should implement this interface.
 * 
 * @author MJ
 *
 */
public interface RequestValidator {

	/**
	 * Returns {@code true} if request is not null; otherwise {@code false}.
	 * 
	 * @param request
	 *            {@link Request}
	 * @return Returns {@code true} if request is not null; otherwise {@code false}.
	 */
	default boolean isRequestNotNull(Request request) {
		return (request == null) ? false : true;
	}

	/**
	 * Validate request and if validation is successful, return {@code true};
	 * otherwise return {@code false}.
	 * 
	 * @return If validation is successful, return {@code true}; otherwise return
	 *         {@code false}.
	 */
	boolean validate(Request request);

}
