package com.indhawk.api.gateway;

public interface ServiceNavigationHelper {
	
	/**
	 * Return domain name for REST microservice. for example - localhost:8080 or www.google.com
	 * @return
	 */
	String getServiceDomainName();
	

}
