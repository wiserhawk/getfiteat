package com.indhawk.auth.sync.restclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component(value="restClientSpringBootTemplate")
public class RestClientSpringBootTemplate implements RestClient {

	RestTemplate restTemplate = new RestTemplate();
	
	@Value("${api.gateway.service.host}")
	private String apiGatewayHost;
	
	@Value("${api.gateway.service.port}")
	private String apiGatewayPort;
	
	@Value("${api.gateway.service.authenticate.user.url}")
	private String authenticateUserURL;
	
	@Value("${api.gateway.service.authenticate.vendor.url}")
	private String authenticateVendorURL;
	
	@Override
	public UserAuthRespose authenticateUser(String id, String password) {
		String authURL = createUrl(apiGatewayHost, apiGatewayPort, authenticateUserURL);
		// Header
		HttpHeaders headers = new HttpHeaders();
		// Body
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>(); 
		params.add("identifier", id);
		params.add("password", password);
		// Request
		HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(params, headers);
		UserAuthRespose response = restTemplate.postForObject(authURL, httpEntity, UserAuthRespose.class);
		return response;
	}
	
	@Override
	public UserAuthRespose authenticateVendor(String id, String password) {
		String authURL = createUrl(apiGatewayHost, apiGatewayPort, authenticateVendorURL);
		// Header
		HttpHeaders headers = new HttpHeaders();
		// Body
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>(); 
		params.add("identifier", id);
		params.add("password", password);
		// Request
		HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(params, headers);
		UserAuthRespose response = restTemplate.postForObject(authURL, httpEntity, UserAuthRespose.class);
		return response;
	}
	
	private String createUrl(String host, String port, String serviceUrl) {
		StringBuffer buffer = new StringBuffer();
		return buffer.append(host).append(":").append(port).append(serviceUrl).toString();
	}

	
	

}
