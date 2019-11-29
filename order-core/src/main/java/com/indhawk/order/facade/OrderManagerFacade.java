package com.indhawk.order.facade;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.indhawk.order.OrderStatus;
import com.indhawk.order.PaymentMode;
import com.indhawk.order.model.OrderModel;
import com.indhawk.order.request.OrderRequest;
import com.indhawk.order.response.Order;
import com.indhawk.order.service.OrderManagerService;

@Component
public class OrderManagerFacade {

	private static final Logger LOG = LoggerFactory.getLogger(OrderManagerFacade.class);
	
	@Autowired
	private OrderManagerService orderManagerService; 
	
	public Order createOrder(OrderRequest request) {
		Order order = null;
		try {
			OrderModel orderModel = orderManagerService.createOrder(request);
			order = new Order();
			BeanUtils.copyProperties(orderModel, order);
		} catch (Exception ex) {
			LOG.error("Order creation failed : ERROR={}", ex);
		}
		return order;
	}
	
	public List<OrderModel> getOrdersByPaymentMode(PaymentMode paymentMode) {
		return orderManagerService.getOrdersByPaymentMode(paymentMode);
	}
	
	public boolean updateOrderStatus(String orderId, OrderStatus status) {
		return orderManagerService.updateOrderStatus(orderId, status);
	}
	
	public OrderModel getOrderByOrderId(String orderId) {
		return orderManagerService.getOrderByOrderId(orderId);
	}
	
	public List<OrderModel> getOrderListByOrderIds(List<String> orderIds) {
		return orderManagerService.getOrderListByOrderIds(orderIds);
	}
	
	public List<OrderModel> getAllConfirmedOrders() {
		return orderManagerService.getAllConfirmedOrders();
	}
	
	public List<OrderModel> getAllShippedOrders() {
		return orderManagerService.getAllShippedOrders();
	}
	
	public List<OrderModel> getAllDeliveredOrders() {
		return orderManagerService.getAllDeliveredOrders();
	}
	
	public List<OrderModel> getAllRejectedOrders() {
		return orderManagerService.getAllRejectedOrders();
	}
	
	public List<OrderModel> getAllFailedOrders() {
		return orderManagerService.getAllFailedOrders();
	}
	
	public List<String> getAllPaymentMethodTypes() {
		return orderManagerService.getAllPaymentMethodTypes();
	}
	
	public List<OrderModel> getAllOrdersByVendorId(String vendorId) {
		return orderManagerService.getAllOrdersByVendorId(vendorId);
		
	}
	
	public List<OrderModel> getAllConfirmedOrdersByVendorId(String vendorId) {
		throw new RuntimeException("Method not implemented yet.");
	}
	
	public List<OrderModel> getAllShippedOrdersByVendorId(String vendorId) {
		throw new RuntimeException("Method not implemented yet.");
	}
	
	public List<OrderModel> getAllDeliveredOrdersByVendorId(String vendorId) {
		throw new RuntimeException("Method not implemented yet.");
	}
	
	public List<OrderModel> getAllRejectedOrdersByVendorId(String vendorId) {
		throw new RuntimeException("Method not implemented yet.");
	}
	
	public List<OrderModel> getAllFailedOrdersByVendorId(String vendorId) {
		throw new RuntimeException("Method not implemented yet.");
	}
}
