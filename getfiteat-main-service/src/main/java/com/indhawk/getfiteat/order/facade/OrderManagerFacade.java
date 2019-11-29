package com.indhawk.getfiteat.order.facade;

import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.indhawk.getfiteat.order.enums.OrderStatus;
import com.indhawk.getfiteat.order.enums.PaymentMode;
import com.indhawk.getfiteat.order.model.OrderModel;
import com.indhawk.getfiteat.order.request.OrderRequest;
import com.indhawk.getfiteat.order.response.Order;
import com.indhawk.getfiteat.order.response.OrderResponse;
import com.indhawk.getfiteat.order.service.OrderManagerService;

@Component
public class OrderManagerFacade {

	private static final Logger LOG = LoggerFactory.getLogger(OrderManagerFacade.class);
	
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyy HH:mm:ss");
	
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
	
	public OrderResponse getOrderByOrderId(String orderId) {
		OrderModel orderModel = orderManagerService.getOrderByOrderId(orderId);
		OrderResponse orderResponse = new OrderResponse();
		BeanUtils.copyProperties(orderModel, orderResponse);
		orderResponse.setOrderDate(DATE_FORMAT.format(orderModel.getOrderDate()));
		return orderResponse;
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
	
	public List<OrderModel> getAllAssignedOrdersByVendorId(String vendorId) {
		return orderManagerService.getAllAssignedOrdersByVendorId(vendorId);
	}
	
	public List<OrderModel> getAllShippedOrdersByVendorId(String vendorId) {
		return orderManagerService.getAllShippedOrdersByVendorId(vendorId);
	}
	
	public List<OrderModel> getAllDeliveredOrdersByVendorId(String vendorId) {
		return orderManagerService.getAllDeliveredOrdersByVendorId(vendorId);
	}
	
	public List<OrderModel> getAllRejectedOrdersByVendorId(String vendorId) {
		return orderManagerService.getAllRejectedOrdersByVendorId(vendorId);
	}
	
	public List<OrderModel> getAllFailedOrdersByVendorId(String vendorId) {
		return orderManagerService.getAllFailedOrdersByVendorId(vendorId);
	}
}
