package com.indhawk.order.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.indhawk.hungersol.order.OrderStatus;
import com.indhawk.hungersol.order.PaymentMode;
import com.indhawk.order.facade.OrderManagerFacade;
import com.indhawk.order.model.OrderModel;
import com.indhawk.order.request.OrderRequest;
import com.indhawk.order.request.OrderStatusRequest;
import com.indhawk.order.response.Order;
import com.indhawk.order.validator.OrderRequestValidator;
import com.indhawk.order.validator.OrderStatusRequestValidator;
import com.indhawk.order.validator.PaymentModeRequestValidator;

@RestController
public class OrderController {
	
	private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderRequestValidator orderRequestValidator;
	
	@Autowired
	private PaymentModeRequestValidator paymentModeRequestValidator;
	
	@Autowired
	private OrderStatusRequestValidator orderStatusRequestValidator;
	
	@Autowired
	private OrderManagerFacade orderManagerFacade;
	
	@RequestMapping(value="/order/createOrder/save", method=RequestMethod.POST)
	public ResponseEntity<Order> createOrder(@RequestBody OrderRequest request) {
		LOG.debug("Request received to create new order. Request={}", request);
		ResponseEntity<Order> orderResponse = null;
		if (orderRequestValidator.validate(request)) {
			Order order = orderManagerFacade.createOrder(request);
			orderResponse = new ResponseEntity<Order>(order, HttpStatus.OK);
			LOG.debug("Created new order. Response={}", order);
		} else {
			orderResponse = new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
		}
		
		return orderResponse;
	}
	
	@RequestMapping(value="/order/orderByPaymentMode/get", method=RequestMethod.POST)
	public ResponseEntity<List<OrderModel>> getOrdersByPaymentMode(String paymentMode) {
		LOG.debug("Request received to get order list by payment mode. PaymentMode={}", paymentMode);
		ResponseEntity<List<OrderModel>> orderListResponse = null;
		if (paymentModeRequestValidator.validate(paymentMode)) {
			PaymentMode pMode = PaymentMode.valueOf(paymentMode.toUpperCase());
			List<OrderModel> orderList = orderManagerFacade.getOrdersByPaymentMode(pMode);
			orderListResponse = new ResponseEntity<List<OrderModel>>(orderList, HttpStatus.OK);
			LOG.debug("Response of order list by payment mode. Response={}", orderList);
		} else {
			orderListResponse = new ResponseEntity<List<OrderModel>>(HttpStatus.BAD_REQUEST);
		}
		
		return orderListResponse;
	}
		
	
	@RequestMapping(value="/order/updateOrderStatus/update", method=RequestMethod.POST)
	public ResponseEntity<Boolean> updateOrderStatus(@RequestBody OrderStatusRequest request) {
		LOG.debug("Request received to update order status. Request={}", request);
		ResponseEntity<Boolean> updateResponse = null;
		if (orderStatusRequestValidator.validate(request)) {
			boolean result = orderManagerFacade.updateOrderStatus(request.getOrderId(), OrderStatus.valueOf(request.getStatus()));
			updateResponse = new ResponseEntity<Boolean>(result, HttpStatus.OK);
			LOG.debug("Response of order status update. Response={}", result);
		} else {
			updateResponse = new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
		return updateResponse;
	}
	
	@RequestMapping(value="/order/orderByOrderId/get", method=RequestMethod.POST)
	public ResponseEntity<OrderModel> getOrderByOrderId(String orderId) {
		
		LOG.debug("Request received to get order by Id. OrderId={}", orderId);
		ResponseEntity<OrderModel> orderResponse = null;
		if (!StringUtils.isEmpty(orderId)) {
			OrderModel order = orderManagerFacade.getOrderByOrderId(orderId);
			orderResponse = new ResponseEntity<OrderModel>(order, HttpStatus.OK);
			LOG.debug("Response of order by Id. Response={}", order);
		} else {
			orderResponse = new ResponseEntity<OrderModel>(HttpStatus.BAD_REQUEST);
		}
		return orderResponse;
	}
	
	@RequestMapping(value="/order/orderListByOrderIds/get", method=RequestMethod.POST)
	public ResponseEntity<List<OrderModel>> getOrderListByOrderIds(@RequestBody List<String> orderIds) {
		LOG.debug("Request received to get order list by orderIds. OrderIds={}", orderIds);
		ResponseEntity<List<OrderModel>> orderListResponse = null;
		if (orderIds.size() > 0) {
			List<OrderModel> orderList = orderManagerFacade.getOrderListByOrderIds(orderIds);
			orderListResponse = new ResponseEntity<List<OrderModel>>(orderList, HttpStatus.OK);
			LOG.debug("Response of order list by orderIds. Response={}", orderList);
		} else {
			orderListResponse = new ResponseEntity<List<OrderModel>>(HttpStatus.BAD_REQUEST);
		}
		return orderListResponse;
	}
	
	@RequestMapping(value="/order/allConfirmedOrders/get", method=RequestMethod.GET)
	public ResponseEntity<List<OrderModel>> getAllConfirmedOrders() {
		LOG.debug("Request received to get order list of confirmed orders.");
		ResponseEntity<List<OrderModel>> orderListResponse = null;
		List<OrderModel> orderList = orderManagerFacade.getAllConfirmedOrders();
		orderListResponse = new ResponseEntity<List<OrderModel>>(orderList, HttpStatus.OK);
		LOG.debug("Response of order list of confirmed orders. Response={}", orderList);
		return orderListResponse;
	}
	
	@RequestMapping(value="/order/allShippedOrders/get", method=RequestMethod.GET)
	public ResponseEntity<List<OrderModel>> getAllShippedOrders() {
		LOG.debug("Request received to get order list of shipped orders.");
		ResponseEntity<List<OrderModel>> orderListResponse = null;
		List<OrderModel> orderList = orderManagerFacade.getAllShippedOrders();
		orderListResponse = new ResponseEntity<List<OrderModel>>(orderList, HttpStatus.OK);
		LOG.debug("Response of order list of confirmed orders. Response={}", orderList);
		return orderListResponse;
		
	}
	
	@RequestMapping(value="/order/allDeliveredOrders/get", method=RequestMethod.GET)
	public ResponseEntity<List<OrderModel>> getAllDeliveredOrders() {
		LOG.debug("Request received to get order list of delivered orders.");
		ResponseEntity<List<OrderModel>> orderListResponse = null;
		List<OrderModel> orderList = orderManagerFacade.getAllDeliveredOrders();
		orderListResponse = new ResponseEntity<List<OrderModel>>(orderList, HttpStatus.OK);
		LOG.debug("Response of order list of delivered orders. Response={}", orderList);
		return orderListResponse;
		
	}
	
	@RequestMapping(value="/order/allRejectedOrders/get", method=RequestMethod.GET)
	public ResponseEntity<List<OrderModel>> getAllRejectedOrders() {
		LOG.debug("Request received to get order list of rejected orders.");
		ResponseEntity<List<OrderModel>> orderListResponse = null;
		List<OrderModel> orderList = orderManagerFacade.getAllRejectedOrders();
		orderListResponse = new ResponseEntity<List<OrderModel>>(orderList, HttpStatus.OK);
		LOG.debug("Response of order list of rejected orders. Response={}", orderList);
		return orderListResponse;
	}
	
	@RequestMapping(value="/order/allFailedOrders/get", method=RequestMethod.GET)
	public ResponseEntity<List<OrderModel>> getAllFailedOrders() {
		LOG.debug("Request received to get order list of failed orders.");
		ResponseEntity<List<OrderModel>> orderListResponse = null;
		List<OrderModel> orderList = orderManagerFacade.getAllFailedOrders();
		orderListResponse = new ResponseEntity<List<OrderModel>>(orderList, HttpStatus.OK);
		LOG.debug("Response of order list of failed orders. Response={}", orderList);
		return orderListResponse;
	}	
	
	@RequestMapping(value="/order/allPaymentMethodTypes/get", method=RequestMethod.GET)
	public ResponseEntity<List<String>> getAllPaymentMethodTypes() {
		List<String> paymentMethodTypes = orderManagerFacade.getAllPaymentMethodTypes();
		ResponseEntity<List<String>> response = new ResponseEntity<List<String>>(paymentMethodTypes, HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value="/order/allOrdersByVendorId/get", method=RequestMethod.GET)
	public ResponseEntity<List<OrderModel>> getAllOrdersByVendorId(String vendorId) {
		LOG.debug("Request received to get order list of confirmed orders.");
		ResponseEntity<List<OrderModel>> orderListResponse = null;
		List<OrderModel> orderList = orderManagerFacade.getAllOrdersByVendorId(vendorId);
		orderListResponse = new ResponseEntity<List<OrderModel>>(orderList, HttpStatus.OK);
		LOG.debug("Response of order list of confirmed orders. Response={}", orderList);
		return orderListResponse;
	}
	
	@RequestMapping(value="/order/allConfirmedOrdersByVendorId/get", method=RequestMethod.GET)
	public ResponseEntity<List<OrderModel>> getAllConfirmedOrdersByVendorId(String vendorId) {
		LOG.debug("Request received to get order list of confirmed orders.");
		ResponseEntity<List<OrderModel>> orderListResponse = null;
		List<OrderModel> orderList = orderManagerFacade.getAllConfirmedOrdersByVendorId(vendorId);
		orderListResponse = new ResponseEntity<List<OrderModel>>(orderList, HttpStatus.OK);
		LOG.debug("Response of order list of confirmed orders. Response={}", orderList);
		return orderListResponse;
	}
	
	@RequestMapping(value="/order/allShippedOrdersByVendorId/get", method=RequestMethod.GET)
	public ResponseEntity<List<OrderModel>> getAllShippedOrdersByVendorId(String vendorId) {
		LOG.debug("Request received to get order list of shipped orders.");
		ResponseEntity<List<OrderModel>> orderListResponse = null;
		List<OrderModel> orderList = orderManagerFacade.getAllShippedOrdersByVendorId(vendorId);
		orderListResponse = new ResponseEntity<List<OrderModel>>(orderList, HttpStatus.OK);
		LOG.debug("Response of order list of confirmed orders. Response={}", orderList);
		return orderListResponse;
		
	}
	
	@RequestMapping(value="/order/allDeliveredOrdersByVendorId/get", method=RequestMethod.GET)
	public ResponseEntity<List<OrderModel>> getAllDeliveredOrdersByVendorId(String vendorId) {
		LOG.debug("Request received to get order list of delivered orders.");
		ResponseEntity<List<OrderModel>> orderListResponse = null;
		List<OrderModel> orderList = orderManagerFacade.getAllDeliveredOrdersByVendorId(vendorId);
		orderListResponse = new ResponseEntity<List<OrderModel>>(orderList, HttpStatus.OK);
		LOG.debug("Response of order list of delivered orders. Response={}", orderList);
		return orderListResponse;
		
	}
	
	@RequestMapping(value="/order/allRejectedOrdersBy/get", method=RequestMethod.GET)
	public ResponseEntity<List<OrderModel>> getAllRejectedOrdersByVendorId(String vendorId) {
		LOG.debug("Request received to get order list of rejected orders.");
		ResponseEntity<List<OrderModel>> orderListResponse = null;
		List<OrderModel> orderList = orderManagerFacade.getAllRejectedOrdersByVendorId(vendorId);
		orderListResponse = new ResponseEntity<List<OrderModel>>(orderList, HttpStatus.OK);
		LOG.debug("Response of order list of rejected orders. Response={}", orderList);
		return orderListResponse;
	}
	
	@RequestMapping(value="/order/allFailedOrders/get", method=RequestMethod.GET)
	public ResponseEntity<List<OrderModel>> getAllFailedOrdersByVendorId(String vendorId) {
		LOG.debug("Request received to get order list of failed orders.");
		ResponseEntity<List<OrderModel>> orderListResponse = null;
		List<OrderModel> orderList = orderManagerFacade.getAllFailedOrdersByVendorId(vendorId);
		orderListResponse = new ResponseEntity<List<OrderModel>>(orderList, HttpStatus.OK);
		LOG.debug("Response of order list of failed orders. Response={}", orderList);
		return orderListResponse;
	}	

}
