package com.indhawk.foods.response;

/**
 * {@link RestResponse} is an interface. Those classes intend to be any response
 * for this REST RESTful Service should implement this interface.
 *
 */
public interface RestResponse<T> {
	
	/**
	 * Get the body of response.
	 * @return
	 */
	long executionTime();

}
