package com.indhawk.auth.sync.restclient;

public interface RestClient {
	
	
	public UserAuthRespose authenticateUser(String id, String password);
	
	public UserAuthRespose authenticateVendor(String id, String password);
	
	

}
