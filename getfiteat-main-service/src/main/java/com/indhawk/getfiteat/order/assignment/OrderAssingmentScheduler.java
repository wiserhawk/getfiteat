package com.indhawk.getfiteat.order.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OrderAssingmentScheduler {
	
	private static final Logger LOG = LoggerFactory.getLogger(OrderAssingmentScheduler.class);
	
	@Autowired
	@Qualifier("orderAssignmentImpl")
	private OrderAssignment orderAssignment;
	
	@Scheduled(fixedDelayString="${order.assignment.scheduler.delay}") // Scheduled for every 1 minute
	public void assignOrders() {
		LOG.info("Initiating orders-assignment scheduler to assign vendor to all confirmed orders");
		orderAssignment.assignOrders();
		LOG.info("Order-assignment scheduler task completed.");
	}

}
