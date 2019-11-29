package com.indhawk.getfiteat.order.assignment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.indhawk.getfiteat.order.dataobj.OrderDO;
import com.indhawk.getfiteat.order.enums.OrderStatus;
import com.indhawk.getfiteat.order.repository.OrderRepository;
import com.indhawk.getfiteat.vendor.manager.dataobj.VendorDO;
import com.indhawk.getfiteat.vendor.manager.repository.VendorDetailsRepository;

@Component("orderAssignmentImpl")
public class OrderAssignmentImpl implements OrderAssignment{
	
	private static final Logger LOG = LoggerFactory.getLogger(OrderAssignmentImpl.class);
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private VendorDetailsRepository vendorDetailsRepository;

	@Override
	public boolean assignOrders() {
		List<OrderDO> ordersList = orderRepository.getAllConfirmedOrders();
		if (ordersList.size() > 0) {
			LOG.info("Found {} orders for vendor assignment", ordersList.size());
			List<VendorDO> vendorList = getAllActiveVendors();
			for (OrderDO order : ordersList) {
				assignOrder(order, vendorList);
			}
			return true;
		}
		LOG.info("No order available for vendor assignment");
		return false;
	}

	@Override
	public boolean isUnassignedOrdersExist() {
		List<OrderDO> ordersList = orderRepository.getAllConfirmedOrders();
		return ordersList.size() > 0 ? true : false;
	}

	@Override
	public int unassignedOrdersSize() {
		return orderRepository.getAllConfirmedOrders().size();
	}
	
	private List<VendorDO> getAllActiveVendors() {
		List<VendorDO> vendorList = vendorDetailsRepository.findAll();
		List<VendorDO> finalVendorList = vendorList.stream().filter(v -> v.isActive()).collect(Collectors.toList());
		return finalVendorList;
	}
	
	private void assignOrder(OrderDO order, List<VendorDO> vendorList) {
		for(VendorDO v : vendorList) {
			List<String> localities = Arrays.asList(v.getLocality().split("\\s*,\\s*"));
			for (String s : localities) {
				if (order.getShipTo().contains(s)) {
					order.setVendorId(v.getVendorId());
					order.setOrderStatus(OrderStatus.ASSIGNED);
					orderRepository.save(order);
					LOG.info("OrderId={} has been assigned VendorId={}", order.getOrderId(), v.getVendorId());
					return;
				}
			}
		}
		
		// If not appropriate vendor found for order.
		order.setOrderStatus(OrderStatus.REJECTED);
		orderRepository.save(order);
		LOG.info("OrderId={} got Rejected due to no appropriate vendor available for order.");
	}

}
