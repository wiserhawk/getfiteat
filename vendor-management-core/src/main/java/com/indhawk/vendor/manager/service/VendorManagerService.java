package com.indhawk.vendor.manager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indhawk.vendor.manager.dataobj.VendorDO;
import com.indhawk.vendor.manager.model.VendorModel;
import com.indhawk.vendor.manager.repository.VendorDetailsRepository;
import com.indhawk.vendor.manager.request.VendorRequest;
import com.indhawk.vendor.manager.response.VendorAuthResponse;
import com.indhawk.vendor.manager.util.Encryptor;
import com.indhawk.vendor.manager.util.FormatUtil;

@Service
public class VendorManagerService {
	
	private static final Logger LOG = LoggerFactory.getLogger(VendorManagerService.class);
	
	private static final String VENDOR_ID_PREFIX = "VD-";
	
	@Autowired
	private VendorDetailsRepository vendorDetailsRepository;
	
	public List<VendorModel> getAllVendorsDeatails() {
		List<VendorDO> vendors = vendorDetailsRepository.findAll();
		List<VendorModel> vendorModels = new ArrayList<>();
		for (VendorDO v : vendors) {
			VendorModel m = new VendorModel();
			BeanUtils.copyProperties(v, m);
			vendorModels.add(m);
		}
		return vendorModels;
	}
	
	public List<VendorModel> getAllActiveVendorsDeatails() {
		List<VendorDO> vendors = vendorDetailsRepository.findAll();
		List<VendorDO> activeVendors = vendors.stream().filter(v -> v.isActive()).collect(Collectors.toList());
		List<VendorModel> activeVendorModels = new ArrayList<>();
		for (VendorDO v : activeVendors) {
			VendorModel m = new VendorModel();
			BeanUtils.copyProperties(v, m);
			activeVendorModels.add(m);
		}
		return activeVendorModels;
	}
	
	public synchronized VendorModel createNewVendor(VendorRequest request) {
		VendorModel vendorModel = null;
		try {
			VendorDO vendorDO = new VendorDO();
			BeanUtils.copyProperties(request, vendorDO);
			vendorDO.setVendorId(getNextVendorId());
			// Encrypt password
			String encryptedPwd = Encryptor.encrypt(vendorDO.getPassword());
			vendorDO.setPassword(encryptedPwd);
			VendorDO vendor = vendorDetailsRepository.save(vendorDO);
			vendorModel = new VendorModel();
			BeanUtils.copyProperties(vendor, vendorModel);
			return vendorModel;
		} catch(Exception ex) {
			LOG.error("Error: Failed to persist VendorDO into DB. Error={}", ex);
		}
		return vendorModel;
	}
	
	public VendorModel getLatestCreatedVendor() {
		VendorDO vendorDO = getLastVendor();
		VendorModel vendorModel = new VendorModel();
		BeanUtils.copyProperties(vendorDO, vendorModel);
		return vendorModel;
	}
	
	public VendorModel getVendorDetailByEmail(String email) {
		VendorDO vendor = vendorDetailsRepository.getVendorByEmail(email);
		VendorModel vendorModel = new VendorModel();
		BeanUtils.copyProperties(vendor, vendorModel);
		return vendorModel;
	}
	
	public VendorModel getVendorDetailByPhone(String phone) {
		VendorDO vendor = vendorDetailsRepository.getVendorByContact(phone);
		VendorModel vendorModel = new VendorModel();
		BeanUtils.copyProperties(vendor, vendorModel);
		return vendorModel;
	}
	
	public VendorModel getVendorDetailByVendorId(String vendorId) {
		VendorDO vendor = vendorDetailsRepository.getVendorByVendorId(vendorId);
		VendorModel vendorModel = new VendorModel();
		BeanUtils.copyProperties(vendor, vendorModel);
		return vendorModel;
	}
	
	public VendorAuthResponse authenticate(String identifier, String password) {
		LOG.debug("Authenticating identifier={}", identifier);
		VendorAuthResponse authResponse = new VendorAuthResponse();
		
		if (FormatUtil.isValidEmailId(identifier)) {
			VendorModel model = getVendorDetailByEmail(identifier);
			if (model != null) {
				String encryptPwd = Encryptor.encrypt(password);
				if (model.getPassword().equals(encryptPwd)) {
					model.setPassword("**************");
					authResponse.setAuthentication(true);
					authResponse.setVendorInfo(model);
					return authResponse;
				}
			}
			
		} else if (FormatUtil.isNumber(identifier)) {
			VendorModel model = getVendorDetailByPhone(identifier);
			if (model != null) {
				String encryptPwd = Encryptor.encrypt(password);
				if (model.getPassword().equals(encryptPwd)) {
					model.setPassword("**************");
					authResponse.setAuthentication(true);
					authResponse.setVendorInfo(model);
					return authResponse;
				}
			}
			
		} else {
			VendorModel model = getVendorDetailByVendorId(identifier);
			if (model != null) {
				String encryptPwd = Encryptor.encrypt(password);
				if (model.getPassword().equals(encryptPwd)) {
					model.setPassword("**************");
					authResponse.setAuthentication(true);
					authResponse.setVendorInfo(model);
					return authResponse;
				}
			}
			
		}
		
		authResponse.setAuthentication(false);
		return authResponse;
		
	}
	
	
	
	private synchronized VendorDO getLastVendor() {
		try {
			VendorDO vendorDO = vendorDetailsRepository.findFirstByOrderByVendorIdDesc();
			return vendorDO;
		} catch (Exception e) {
			LOG.error("Error: Failed to get latest created VendorDO into DB. Error={}", e);
			throw new RuntimeException("Failed to get latest created VendorDO into DB");
		}
		
	}
	
	private synchronized String getNextVendorId() {
		VendorDO vendorDO = getLastVendor();
		String lastVendorID = vendorDO.getVendorId();
		Long nextID = Long.parseLong(lastVendorID.split("-")[1]) + 1;
		String nextVendorID = VENDOR_ID_PREFIX + nextID;
		return nextVendorID;
	}

}
