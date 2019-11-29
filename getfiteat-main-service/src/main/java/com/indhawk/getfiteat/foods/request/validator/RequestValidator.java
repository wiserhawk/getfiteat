package com.indhawk.getfiteat.foods.request.validator;

import com.indhawk.getfiteat.foods.request.RestRequest;

/**
 * This is an interface to validate any type of {@link RestRequest}. Those
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
	 *            {@link RestRequest}
	 * @return Returns {@code true} if request is not null; otherwise {@code false}.
	 */
	default boolean isRequestNotNull(RestRequest request) {
		return (request == null) ? false : true;
	}

	/**
	 * Validate request and if validation is successful, return {@code true};
	 * otherwise return {@code false}.
	 * 
	 * @return If validation is successful, return {@code true}; otherwise return
	 *         {@code false}.
	 */
	boolean validate(RestRequest request);

}
