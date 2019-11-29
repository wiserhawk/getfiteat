package com.indhawk.getfiteat.billing.gst;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GSTManager {
	
	private static final Logger LOG = LoggerFactory.getLogger(GSTManager.class);
	
	private static final Map<GSTProductType, GSTDetails> GST_DETAIL_CAHCE = new HashMap<>();
	
	@Value("${food.gst}")
	private float gst;
	@Value("${food.cgst}")
	private float cgst;
	@Value("${food.sgst}")
	private float sgst;
	
	private static boolean initialized = false;
	
	public GSTManager() {
		super();
	}
	
	private void init() {
		if (!initialized) {
			GSTDetails gstDetail = new GSTDetails(GSTProductType.FOOD, gst, cgst, sgst);
			GST_DETAIL_CAHCE.put(GSTProductType.FOOD, gstDetail);
			LOG.info("GST Cache initialized successfully. GSTDetails={}", gstDetail);
			this.initialized = true;
		}
	}
	
	public Collection<GSTDetails> getAllGSTDetails() {
		init();
		return GST_DETAIL_CAHCE.values();
	}

	public GSTDetails getGSTDetail(GSTProductType type) {
		init();
		return GST_DETAIL_CAHCE.get(type);
	}
}
