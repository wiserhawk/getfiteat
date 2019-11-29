package com.indhawk.api.gateway.restclient;

import org.springframework.web.client.RestTemplate;

public abstract class AbstractRestClient implements RestClient {
	
	private RestTemplate restTemp = new RestTemplate();
	
	@Override
	public RestTemplate getRestClient() {
		return restTemp;
	}

}
