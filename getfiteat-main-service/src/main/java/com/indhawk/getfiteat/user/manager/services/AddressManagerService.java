package com.indhawk.getfiteat.user.manager.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indhawk.getfiteat.user.manager.model.AddressDetailModel;
import com.indhawk.getfiteat.user.manager.mongodb.dataobj.AddressDetailDO;
import com.indhawk.getfiteat.user.manager.mongodb.repository.AddressDetailRepository;
import com.indhawk.getfiteat.user.manager.request.AddressRequest;

@Service
public class AddressManagerService {
	
	private static final Logger LOG = LoggerFactory.getLogger(AddressManagerService.class);
	
	private static final String ADDRESS_NUMBER_PREFIX = "ADD";
	
	private static final int INITIAL_ADDRESS_NUMBER = 1;
	
	
	@Autowired
	private AddressDetailRepository addressDetailRepository;
	
	public AddressDetailModel createUserAddress(AddressRequest address) {
		LOG.debug("Creating new address for user. request={}", address);
		String addressNum = getNextAddressNum(address.getUserId());
		AddressDetailDO addressDetailDO = new AddressDetailDO();
		BeanUtils.copyProperties(address, addressDetailDO);
		addressDetailDO.setAddressNum(addressNum);
		AddressDetailDO finalAddressDetail = addressDetailRepository.save(addressDetailDO);
		AddressDetailModel addressDetailModel =  new AddressDetailModel();
		BeanUtils.copyProperties(finalAddressDetail, addressDetailModel);
		LOG.debug("Address successfully created for user. AddressDetail={}", addressDetailModel);
		return addressDetailModel;
	}
	
	public List<AddressDetailModel> getAddressDetailsByUserId(String userId) {
		LOG.debug("Getting address details by userId={}", userId);
		List<AddressDetailModel> addressDetailModelList = new ArrayList<>();
		List<AddressDetailDO> addressDetailDoList = addressDetailRepository.getAddressDetailsByUserId(userId);
		if (addressDetailDoList != null) {
			for (AddressDetailDO address : addressDetailDoList) {
				AddressDetailModel addressDetailModel = new AddressDetailModel();
				BeanUtils.copyProperties(address, addressDetailModel);
				addressDetailModelList.add(addressDetailModel);
			}
		}
		return addressDetailModelList;	
	}
	
	public AddressDetailModel getAddressDetailsByAddressNum(String addressNum) {
		LOG.debug("Getting address details by addressNumber={}", addressNum);
		AddressDetailModel addressDetailModel = null;
		AddressDetailDO addressDetailDo = addressDetailRepository.getAddressDetailByAddressNum(addressNum);
		if (addressDetailDo != null) {
			addressDetailModel = new AddressDetailModel();
			BeanUtils.copyProperties(addressDetailDo, addressDetailModel);
		}
		return addressDetailModel;	
	}
	
	
	public String getNextAddressNum(String userId) {
		AddressDetailDO addressDetail = addressDetailRepository.findTopByOrderByAddressNumDesc();
		String nextAddressNum = null;
		String currentAddressNum = null;
		if (addressDetail != null) {
			currentAddressNum = addressDetail.getAddressNum();
			String[] addNum = currentAddressNum.split("_");
			int nextNumber = Integer.parseInt(addNum[1].substring(3)) + 1;
			nextAddressNum = userId + "_" + ADDRESS_NUMBER_PREFIX + nextNumber;
		} else {
			nextAddressNum = userId + "_" +  ADDRESS_NUMBER_PREFIX + INITIAL_ADDRESS_NUMBER;
		}
		return nextAddressNum;
	}
	

}
