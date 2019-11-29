package com.indhawk.api.gateway.restclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.indhawk.api.gateway.user.request.AddressRequest;
import com.indhawk.api.gateway.user.request.UserDetailRequest;

@Component(value="userServiceRestClientImpl")
public class UserServiceRestClientImpl extends AbstractRestClient implements UserServiceRestClient {
	
	@Value("${app.user.service.host}")
	private String appUserServiceHost;
	
	@Value("${app.user.service.port}")
	private String appUserServicePort;
	
	@Value("${app.user.service.create.user.account}")
	private String createUserAccountURL;
	
	@Value("${app.user.service.get.user.detail.by.email}")
	private String getUserDetailByEmailURL;
	
	@Value("${app.user.service.get.user.detail.by.phone}")
	private String getUserDetailByPhoneURL;

	@Value("${app.user.service.get.user.detail.by.id}")
	private String getUserDetailByIdURL;
	
	@Value("${app.user.service.create.user.address}")
	private String createUserAddressURL;
	
	@Value("${app.user.service.get.address.details.by.user.id}")
	private String getAddressDetailsByUserIdURL;
	
	@Value("${app.user.service.get.address.detail.by.address.number}")
	private String getAddressDetailByAddressNumberURL;
	
	
	@Value("${app.user.service.authenticate.user}")
	private String userAuthenticateURL;

	@Override
	public String getRootURL() {
		StringBuilder builder = new StringBuilder();
		builder.append(appUserServiceHost);
		builder.append(":");
		builder.append(appUserServicePort);
		return builder.toString();
	}

	@Override
	public ResponseEntity<Object> createUserAccount(UserDetailRequest request) {
		String url = getRootURL() + createUserAccountURL;
		ResponseEntity<Object> resposneEntity = getRestClient().postForEntity(url, request, Object.class);
		return resposneEntity;
	}

	@Override
	public ResponseEntity<Object> getUserDetailByEmail(String email) {
		String url = getRootURL() + getUserDetailByEmailURL;
		// Header
		HttpHeaders headers = new HttpHeaders();
		// Body
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>(); 
		params.add("email", email);
		// Request
		HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(params, headers);
		ResponseEntity<Object> resposneEntity = getRestClient().postForEntity(url, httpEntity, Object.class);
		return resposneEntity;
	}

	@Override
	public ResponseEntity<Object> getUserDetailByPhone(String phone) {
		String url = getRootURL() + getUserDetailByPhoneURL;
		// Header
		HttpHeaders headers = new HttpHeaders();
		// Body
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>(); 
		params.add("phone", phone);
		// Request
		HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(params, headers);
		ResponseEntity<Object> resposneEntity = getRestClient().postForEntity(url, httpEntity, Object.class);
		return resposneEntity;
	}

	@Override
	public ResponseEntity<Object> getUserDetailByUserId(String userId) {
		String url = getRootURL() + getUserDetailByIdURL;
		// Header
		HttpHeaders headers = new HttpHeaders();
		// Body
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>(); 
		params.add("userId", userId);
		// Request
		HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(params, headers);
		ResponseEntity<Object> resposneEntity = getRestClient().postForEntity(url, httpEntity, Object.class);
		return resposneEntity;
	}

	@Override
	public ResponseEntity<Object> createUserAddress(AddressRequest address) {
		String url = getRootURL() + createUserAddressURL;
		ResponseEntity<Object> resposneEntity = getRestClient().postForEntity(url, address, Object.class);
		return resposneEntity;
	}

	@Override
	public ResponseEntity<Object> getAddressDetailsByUserId(String userId) {
		String url = getRootURL() + getAddressDetailsByUserIdURL;
		// Header
		HttpHeaders headers = new HttpHeaders();
		// Body
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>(); 
		params.add("userId", userId);
		// Request
		HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(params, headers);
		ResponseEntity<Object> resposneEntity = getRestClient().postForEntity(url, httpEntity, Object.class);
		return resposneEntity;
	}

	@Override
	public ResponseEntity<Object> getAddressDetailByAddressNumber(String addressNumber) {
		String url = getRootURL() + getAddressDetailByAddressNumberURL;
		// Header
		HttpHeaders headers = new HttpHeaders();
		// Body
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>(); 
		params.add("addressNumber", addressNumber);
		// Request
		HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(params, headers);
		ResponseEntity<Object> resposneEntity = getRestClient().postForEntity(url, httpEntity, Object.class);
		return resposneEntity;
	}

	@Override
	public ResponseEntity<Object> authenticateUser(String identifier, String password) {
		String url = getRootURL() + userAuthenticateURL;
		// Header
		HttpHeaders headers = new HttpHeaders();
		// Body
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>(); 
		params.add("identifier", identifier);
		params.add("password", password);
		// Request
		HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(params, headers);
		ResponseEntity<Object> resposneEntity = getRestClient().postForEntity(url, httpEntity, Object.class);
		return resposneEntity;
	}

}
