package com.indhawk.getfiteat.availability.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indhawk.getfiteat.availability.dataobj.AreaDO;
import com.indhawk.getfiteat.availability.model.AreaModel;
import com.indhawk.getfiteat.availability.repository.AreaRepository;
import com.indhawk.getfiteat.availability.request.AreaRequest;

@Service
public class AvailabilityService {
	
	private static final Logger LOG = LoggerFactory.getLogger(AvailabilityService.class);
	
	@Autowired
	private AreaRepository areaRepo;
	
	public Boolean checkAvailabilityByPincode(String pincode) {
		List<AreaDO> areaDOList = areaRepo.getAreasByPincode(pincode);
		if (areaDOList != null && areaDOList.size() > 0) {
			LOG.debug("We have availablity for PINCODE={}", pincode);
			LOG.debug("Availablity for Areas={}", areaDOList);
			return true;
		}
		LOG.debug("No availablity for PINCODE={}", pincode);
		return false;
	}
	
	public AreaModel createNewArea(AreaRequest area) {
		AreaDO areaDO = new AreaDO();
		BeanUtils.copyProperties(area, areaDO);
		AreaDO resultDO = areaRepo.save(areaDO);
		AreaModel areaModel = new AreaModel();
		BeanUtils.copyProperties(resultDO, areaModel);
		return areaModel;
	}

}
