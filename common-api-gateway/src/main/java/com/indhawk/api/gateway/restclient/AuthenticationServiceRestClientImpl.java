package com.indhawk.api.gateway.restclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.indhawk.api.gateway.auth.request.LoginRequest;

@Component(value="authenticationServiceRestClientImpl")
public class AuthenticationServiceRestClientImpl extends AbstractRestClient implements AuthenticationServiceRestClient {

	@Value("${app.auth.service.host}")
	private String appAuthServiceHost;
	
	@Value("${app.auth.service.port}")
	private String appAuthServicePort;
	
	@Value("${app.auth.service.authenticate.user}")
	private String authenticateUserURL;
	
	@Value("${app.auth.service.authenticate.vendor}")
	private String authenticateVendorURL;
	
	@Override
	public String getRootURL() {
		StringBuilder builder = new StringBuilder();
		builder.append(appAuthServiceHost);
		builder.append(":");
		builder.append(appAuthServicePort);
		return builder.toString();
	}

	@Override
	public ResponseEntity<Object> authenticateUser(LoginRequest credential) {
		String url = getRootURL() + authenticateUserURL;
		ResponseEntity<Object> resposneEntity = getRestClient().postForEntity(url, credential, Object.class);
		return resposneEntity;
	}

	@Override
	public ResponseEntity<Object> authenticateVendor(LoginRequest credential) {
		String url = getRootURL() + authenticateVendorURL;
		ResponseEntity<Object> resposneEntity = getRestClient().postForEntity(url, credential, Object.class);
		return resposneEntity;
	}

}
