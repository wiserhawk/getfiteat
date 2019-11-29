package com.indhawk.unique.sequence.order;

import com.indhawk.unique.sequence.SimpleUniqueSequenceBuilder;
import com.indhawk.unique.sequence.UniqueSequenceBuilder;

public class OrderUniqueSequenceGenerator {

	private static UniqueSequenceBuilder<Long> sequenceBuilder;
	
	private static final String ORDER_PREFIX = "BB-";
	
	private static volatile boolean init = false;
	
	private volatile static OrderUniqueSequenceGenerator instance; 
	
	private OrderUniqueSequenceGenerator() {
		
	}
	
	public static synchronized OrderUniqueSequenceGenerator getInstance(Long initailID) {
		if (!init) {
			instance = new OrderUniqueSequenceGenerator();
			if (initailID == null)
				sequenceBuilder = new SimpleUniqueSequenceBuilder();
			else
				sequenceBuilder = new SimpleUniqueSequenceBuilder(initailID);
			init = true;
		}
		return instance;
	}
	
	public String getNextOrderId() {
		StringBuilder orderId = new StringBuilder(ORDER_PREFIX);
		orderId.append(sequenceBuilder.getNextId());
		return orderId.toString();
	}

}
