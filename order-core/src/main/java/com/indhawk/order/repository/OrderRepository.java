package com.indhawk.order.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.indhawk.order.PaymentMode;
import com.indhawk.order.dataobj.OrderDO;
import com.indhawk.order.model.OrderModel;

@Repository
public interface OrderRepository extends MongoRepository<OrderDO, String> {
	
	public OrderDO getOrderByOrderId(String orderId);
	
	@Query("{'paymentMode': ?0 }")
	public List<OrderDO> getOrdersByPaymentMode(String paymentMode);
	
	@Query("{ 'orderId': {$in: ?0} }")
	public List<OrderDO> getOrderListByOrderIds(List<String> orderIds);
	
	@Query("{ 'orderStatus': 'CONFIRMED' }")
	public List<OrderDO> getAllConfirmedOrders();
	
	@Query("{ 'orderStatus': 'SHIPPED' }")
	public List<OrderDO> getAllShippedOrders();
	
	@Query("{ 'orderStatus': 'DELIVERED' }")
	public List<OrderDO> getAllDeliveredOrders();
	
	@Query("{ 'orderStatus': 'REJECTED' }")
	public List<OrderDO> getAllRejectedOrders();
	
	@Query("{ 'orderStatus': 'FAILED' }")
	public List<OrderDO> getAllFailedOrders();
	
	public List<OrderDO> getAllOrdersByVendorId(String vendorId);
	
	@Query("{ 'orderStatus': 'CONFIRMED', 'vendorId': ?0 }")
	public List<OrderDO> getAllConfirmedOrdersByVendorId(String vendorId);
	
	@Query("{ 'orderStatus': 'SHIPPED', 'vendorId': ?0 }")
	public List<OrderDO> getAllShippedOrdersByVendorId(String vendorId);
	
	@Query("{ 'orderStatus': 'DELIVERED', 'vendorId': ?0 }")
	public List<OrderDO> getAllDeliveredOrdersByVendorId(String vendorId);
	
	@Query("{ 'orderStatus': 'REJECTED', 'vendorId': ?0 }")
	public List<OrderDO> getAllRejectedOrdersByVendorId(String vendorId);
	
	@Query("{ 'orderStatus': 'FAILED', 'vendorId': ?0 }")
	public List<OrderDO> getAllFailedOrdersByVendorId(String vendorId);
	
	

}
