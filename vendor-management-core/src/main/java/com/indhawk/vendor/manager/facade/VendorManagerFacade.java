package com.indhawk.vendor.manager.facade;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.indhawk.vendor.manager.dataobj.VendorDO;
import com.indhawk.vendor.manager.model.VendorModel;
import com.indhawk.vendor.manager.request.VendorRequest;
import com.indhawk.vendor.manager.response.VendorAuthResponse;
import com.indhawk.vendor.manager.response.VendorDetailResponse;
import com.indhawk.vendor.manager.service.VendorManagerService;

@Component
public class VendorManagerFacade {
	
	private static final Logger LOG = LoggerFactory.getLogger(VendorManagerFacade.class);
	
	@Autowired
	private VendorManagerService vendorManagerService;
	
	
	public List<VendorDetailResponse> getAllVendorsDeatails() {
		List<VendorDetailResponse> response = null;
		List<VendorModel> models = vendorManagerService.getAllVendorsDeatails();
		if (!models.isEmpty()) {
			response = new ArrayList<>();
			for (VendorModel m : models) {
				VendorDetailResponse r = new VendorDetailResponse();
				BeanUtils.copyProperties(m, r);
				response.add(r);
			}
		}
		return response;
	}
	
	public List<VendorDetailResponse> getAllActiveVendorsDeatails() {
		List<VendorDetailResponse> response = null;
		List<VendorModel> models = vendorManagerService.getAllActiveVendorsDeatails();
		if (!models.isEmpty()) {
			response = new ArrayList<>();
			for (VendorModel m : models) {
				VendorDetailResponse r = new VendorDetailResponse();
				BeanUtils.copyProperties(m, r);
				response.add(r);
			}
		}
		return response;
	}
	
	
	public boolean createNewVendor(VendorRequest request) {
		VendorModel vendorModel = vendorManagerService.createNewVendor(request);
		if (vendorModel != null) {
			return true;
		}
		return false;
	}
	
	public VendorDetailResponse getVendorDetailByEmail(String email) {
		VendorModel model = vendorManagerService.getVendorDetailByEmail(email);
		VendorDetailResponse response = new VendorDetailResponse();
		BeanUtils.copyProperties(model, response);
		return response;
	}
	
	public VendorDetailResponse getVendorDetailByPhone(String phone) {
		VendorModel model = vendorManagerService.getVendorDetailByPhone(phone);
		VendorDetailResponse response = new VendorDetailResponse();
		BeanUtils.copyProperties(model, response);
		return response;
	}
	
	public VendorDetailResponse getVendorDetailByVendorId(String vendorId) {
		VendorModel model = vendorManagerService.getVendorDetailByPhone(vendorId);
		VendorDetailResponse response = new VendorDetailResponse();
		BeanUtils.copyProperties(model, response);
		return response;
	}
	
	public VendorAuthResponse authenticate(String identifier, String password) {
		VendorAuthResponse response = vendorManagerService.authenticate(identifier, password);
		return response;
	}

}
