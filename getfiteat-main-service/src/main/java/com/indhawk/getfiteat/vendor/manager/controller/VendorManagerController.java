package com.indhawk.getfiteat.vendor.manager.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.indhawk.getfiteat.vendor.manager.facade.VendorManagerFacade;
import com.indhawk.getfiteat.vendor.manager.request.VendorRequest;
import com.indhawk.getfiteat.vendor.manager.response.VendorAuthResponse;
import com.indhawk.getfiteat.vendor.manager.response.VendorDetailResponse;
import com.indhawk.getfiteat.vendor.manager.validator.VendorRequestValidator;

@RestController
public class VendorManagerController {
	
	private static final Logger LOG = LoggerFactory.getLogger(VendorManagerController.class);
	
	@Autowired
	private VendorRequestValidator vendorRequestValidator;
	
	@Autowired
	private VendorManagerFacade vendorManagerFacade;
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="gfe-main/vendor-manager/getAllVendorsDetails", method=RequestMethod.GET)
	public ResponseEntity<Object> getAllVendorsDeatails() {
		ResponseEntity<Object> respnose = null;
		long startTime = System.currentTimeMillis();
		List<VendorDetailResponse> result = vendorManagerFacade.getAllVendorsDeatails();
		long endTime = System.currentTimeMillis();
		LOG.info("URL gfe-main/vendor-manager/getAllVendorsDetails time taken = {}", (endTime - startTime));
		respnose = new ResponseEntity<Object>(result, HttpStatus.OK);
		return respnose;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="gfe-main/vendor-manager/getAllActiveVendorsDetails", method=RequestMethod.GET)
	public ResponseEntity<Object> getAllActiveVendorsDeatails() {
		ResponseEntity<Object> respnose = null;
		long startTime = System.currentTimeMillis();
		List<VendorDetailResponse> result = vendorManagerFacade.getAllActiveVendorsDeatails();
		long endTime = System.currentTimeMillis();
		LOG.info("URL gfe-main/vendor-manager/getAllActiveVendorsDetails time taken = {}", (endTime - startTime));
		respnose = new ResponseEntity<Object>(result, HttpStatus.OK);
		return respnose;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="gfe-main/vendor-manager/VendorAccount/create", method=RequestMethod.POST)
	public ResponseEntity<Object> createVendor(@RequestBody VendorRequest request) {
		ResponseEntity<Object> respnose = null;
		if (vendorRequestValidator.validate(request)) {
			long startTime = System.currentTimeMillis();
			boolean result = vendorManagerFacade.createNewVendor(request);
			long endTime = System.currentTimeMillis();
			LOG.info("URL gfe-main/vendor-manager/VendorAccount/create time taken = {}", (endTime - startTime));
			respnose = new ResponseEntity<Object>(result, HttpStatus.OK);
		} else {
			LOG.error("ERROR: Input is not correct. Request=", request);
			respnose = new ResponseEntity<Object>(false, HttpStatus.BAD_REQUEST);
		}
		return respnose;
		
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "gfe-main/vendor-manager/vendorDetailByEmail/get", method = RequestMethod.POST)
	public ResponseEntity<Object> getVendorDetailByEmail(String email) {
		try {
			if (!StringUtils.isEmpty(email)) {
				long startTime = System.currentTimeMillis();
				VendorDetailResponse userInfo = vendorManagerFacade.getVendorDetailByEmail(email);
				long endTime = System.currentTimeMillis();
				ResponseEntity<Object> respnose = new ResponseEntity<Object>(userInfo, HttpStatus.OK);
				LOG.info("URL gfe-main/vendor-manager/vendorDetailByEmail/get time taken = {}", (endTime - startTime));
				return respnose;
			} else {
				LOG.error("ERROR: Input Email is not available. Email={}", email);
				ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>("Email parameter is either null or empty.", HttpStatus.BAD_REQUEST);
				return errorRespnose;
			}
		} catch(Exception e) {
			LOG.error(e.getMessage());
			ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			return errorRespnose;
		}
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "gfe-main/vendor-manager/vendorDetailByPhone/get", method = RequestMethod.POST)
	public ResponseEntity<Object> getVendorDetailByPhone(String phone) {
		try {
			if (!StringUtils.isEmpty(phone)) {
				long startTime = System.currentTimeMillis();
				VendorDetailResponse userInfo = vendorManagerFacade.getVendorDetailByPhone(phone);
				long endTime = System.currentTimeMillis();
				ResponseEntity<Object> respnose = new ResponseEntity<Object>(userInfo, HttpStatus.OK);
				LOG.info("URL gfe-main/vendor-manager/vendorDetailByPhone/get time taken = {}", (endTime - startTime));
				return respnose;
			} else {
				LOG.error("ERROR: Input Phone is not available. Phone={}", phone);
				ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>("Phone parameter is either null or empty.", HttpStatus.BAD_REQUEST);
				return errorRespnose;
			}
		} catch(Exception e) {
			LOG.error(e.getMessage());
			ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			return errorRespnose;
		}
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "gfe-main/vendor-manager/vendorDetailByVendorId/get", method = RequestMethod.POST)
	public ResponseEntity<Object> getVendorDetailByVendorId(String vendorId) {
		try {
			if (!StringUtils.isEmpty(vendorId)) {
				long startTime = System.currentTimeMillis();
				VendorDetailResponse userInfo = vendorManagerFacade.getVendorDetailByVendorId(vendorId);
				long endTime = System.currentTimeMillis();
				ResponseEntity<Object> respnose = new ResponseEntity<Object>(userInfo, HttpStatus.OK);
				LOG.info("URL gfe-main/vendor-manager/vendorDetailByVendorId/get time taken = {}", (endTime - startTime));
				return respnose;
			} else {
				LOG.error("ERROR: Input VendorID is not available. VendorId={}", vendorId);
				ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>("Vendor ID parameter is either null or empty.", HttpStatus.BAD_REQUEST);
				return errorRespnose;
			}
		} catch(Exception e) {
			LOG.error(e.getMessage());
			ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			return errorRespnose;
		}
	}
	
	
	/**
	 * Return authentication status {@code true/false } based of credential provided.
	 * {@code identifier} either will be email id or phone number. 
	 * @param identifier Either will be email id or phone number. 
	 * @param password un-encrypted password.
	 * @return
	 */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "gfe-main/vendor-manager/authenticate", method = RequestMethod.POST)
	public ResponseEntity<Object> authenticateVendor(String identifier, String password) {
		try {
			if (!StringUtils.isEmpty(identifier) && !StringUtils.isEmpty(password) ) {
				long startTime = System.currentTimeMillis();
				VendorAuthResponse authResponse = vendorManagerFacade.authenticate(identifier, password);
				long endTime = System.currentTimeMillis();
				ResponseEntity<Object> respnose = new ResponseEntity<Object>(authResponse, HttpStatus.OK);
				LOG.info("URL gfe-main/vendor-manager/authenticate time taken = {}", (endTime - startTime));
				return respnose;
			} else {
				LOG.error("ERROR: Input identifier / password is not available. identifier={}, is_password_empty={}", identifier, StringUtils.isEmpty(password));
				ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>("Input identifier / password is either null or empty.", HttpStatus.BAD_REQUEST);
				return errorRespnose;
			}
		} catch(Exception e) {
			LOG.error(e.getMessage());
			ResponseEntity<Object> errorRespnose = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			return errorRespnose;
		}
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "gfe-main/vendor-manager/getVendorOrders", method = RequestMethod.POST)
	public ResponseEntity<Object> getVendorOrders(String vendorId) {
		return null;
	}


}
