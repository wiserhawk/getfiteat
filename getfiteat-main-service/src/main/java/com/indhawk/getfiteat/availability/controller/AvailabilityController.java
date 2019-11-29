package com.indhawk.getfiteat.availability.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.indhawk.getfiteat.availability.model.AreaModel;
import com.indhawk.getfiteat.availability.request.AreaRequest;
import com.indhawk.getfiteat.availability.service.AvailabilityService;

@RestController
@RequestMapping("gfe-main/availability/")
public class AvailabilityController {
	
	private static final Logger LOG = LoggerFactory.getLogger(AvailabilityController.class);
	
	@Autowired
	private AvailabilityService availabilityService;
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="checkByPincode/{pincode}", method=RequestMethod.GET)
	public ResponseEntity<Boolean> checkDeliveryAvailability(@PathVariable String pincode) {
		Boolean availibility = availabilityService.checkAvailabilityByPincode(pincode);
		return new ResponseEntity<Boolean>(availibility, HttpStatus.OK);
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="createNewArea", method=RequestMethod.POST)
	public ResponseEntity<AreaModel> checkDeliveryAvailability(@RequestBody AreaRequest area) {
		AreaModel areaModel = availabilityService.createNewArea(area);
		return new ResponseEntity<AreaModel>(areaModel, HttpStatus.OK);
	}
	
	
	
}
