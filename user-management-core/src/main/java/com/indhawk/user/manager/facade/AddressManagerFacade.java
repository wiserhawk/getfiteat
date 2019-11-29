package com.indhawk.user.manager.facade;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.indhawk.user.manager.model.AddressDetailModel;
import com.indhawk.user.manager.request.AddressRequest;
import com.indhawk.user.manager.response.AddressResponse;
import com.indhawk.user.manager.services.AddressManagerService;

@Component
public class AddressManagerFacade {
	
	private static final Logger LOG = LoggerFactory.getLogger(AddressManagerFacade.class);
	
	@Autowired
	private AddressManagerService addressManagerService;
	
	public AddressResponse createUserAddress(AddressRequest address) {
		try {
			AddressDetailModel addressDetailModel = addressManagerService.createUserAddress(address);
			AddressResponse addressResponse = new AddressResponse();
			BeanUtils.copyProperties(addressDetailModel, addressResponse);
			return addressResponse;
		} catch (Exception e) {
			LOG.error("Error: Failed to create address for user", e);
			throw new RuntimeException("Opps!!! Some error occured in server. please try again after sometime.");
		}
	}
	
	
	public List<AddressResponse> getAddressDetailsByUserId(String userId) {
		List<AddressResponse> responseList = new ArrayList<>();
		List<AddressDetailModel> models = addressManagerService.getAddressDetailsByUserId(userId);
		if (models !=null) {
			for (AddressDetailModel model : models) {
				if (model != null) {
					AddressResponse response = new AddressResponse();
					BeanUtils.copyProperties(model, response);
					responseList.add(response);
				}
			}
			return responseList;
		}
		LOG.error("Error: Address Details for userId={} in null", userId);
		throw new RuntimeException("Address Detail is not available for userId=" + userId);
	}
	
	public AddressResponse getAddressDetailsByAddressNum(String addressNumber) {
		AddressResponse response = null;
		AddressDetailModel model = addressManagerService.getAddressDetailsByAddressNum(addressNumber);
		if (model !=null) {
			response = new AddressResponse();
			BeanUtils.copyProperties(model, response);
			return response;
		}
		LOG.error("Error: Address Details for AddressNumber={} in null", addressNumber);
		throw new RuntimeException("Address Detail is not available for AddressNum=" + addressNumber);
	}

}
