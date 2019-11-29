package com.indhawk.getfiteat.order.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.indhawk.getfiteat.order.dataobj.InvoiceDO;
import com.indhawk.getfiteat.order.dataobj.InvoiceNumberDO;
import com.indhawk.getfiteat.order.dataobj.ItemDO;
import com.indhawk.getfiteat.order.dataobj.OrderDO;
import com.indhawk.getfiteat.order.dataobj.OrderNumberDO;
import com.indhawk.getfiteat.order.enums.OrderStatus;
import com.indhawk.getfiteat.order.enums.PaymentMode;
import com.indhawk.getfiteat.order.model.InvoiceModel;
import com.indhawk.getfiteat.order.model.OrderModel;
import com.indhawk.getfiteat.order.repository.InvoiceNumberRepository;
import com.indhawk.getfiteat.order.repository.OrderNumberRepository;
import com.indhawk.getfiteat.order.repository.OrderRepository;
import com.indhawk.getfiteat.order.request.Bill;
import com.indhawk.getfiteat.order.request.Item;
import com.indhawk.getfiteat.order.request.OrderRequest;
import com.indhawk.getfiteat.order.util.UniqueIdentityProvider;

@Service
public class OrderManagerService {
	
	private static final Logger LOG = LoggerFactory.getLogger(OrderManagerService.class);
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderNumberRepository orderNumberRepository;
	
	@Autowired
	private InvoiceNumberRepository invoiceNumberRepository;
	
	@Autowired
	private UniqueIdentityProvider uniqueIdentityProvider;
	
	@Value("${company.pan}")
	private String companyPan;
	
	@Value("${company.cin}")
	private String companyCin;
	
	@Value("${order.id.prefix}")
	private String orderIdPrefix;
	
	@Value("${invoice.id.prefix}")
	private String invoiceIdPrefix;
	
	public OrderModel createOrder(OrderRequest request) {
		OrderDO orderResult = new OrderDO();
		try {
			OrderDO orderDO = mapOrderRequestToOrderDO(request);
			if (PaymentMode.CASH == orderDO.getPaymentMode()) {
				// No need to wait for payment confirmation. Therefore we confirming order at first place.
				orderDO.setOrderStatus(OrderStatus.CONFIRMED);
			} else if(PaymentMode.ONLINE == orderDO.getPaymentMode()) {
				orderDO.setOrderStatus(OrderStatus.PAYMENT_PENDING);
			} else {
				throw new RuntimeException("ERROR: There is invalid payment mode in order request."); 
			}
			orderResult = orderRepository.save(orderDO);
			// Split Long number from OrderId or Invoice Id.
			Long orderId = Long.parseLong(orderDO.getOrderId().split("-")[1]);
			Long invoiceId = Long.parseLong(orderDO.getInvoice().getInvoiceNumber().split("-")[1]);
			// Save OrderId and InvoiceId in different table as well.
			OrderNumberDO orderNumDO = null;
			InvoiceNumberDO invoiceNumDO = null;
			if (orderResult != null) {
				orderNumDO = new OrderNumberDO(orderId, true);
				invoiceNumDO = new InvoiceNumberDO(invoiceId, true);
			} else {
				orderNumDO = new OrderNumberDO(orderId, false);
				invoiceNumDO = new InvoiceNumberDO(invoiceId, false);
			}
			orderNumberRepository.save(orderNumDO);
			invoiceNumberRepository.save(invoiceNumDO);
		} catch (Exception ex) {
			LOG.error("ERROR: Failed to persist OrderDO in DB. ERROR={}", ex);
			orderResult.setOrderStatus(OrderStatus.FAILED);
		}
		return mapOrderDOToOrderModel(orderResult);
	}
	
	public List<OrderModel> getOrdersByPaymentMode(PaymentMode paymentMode) {
		List<OrderDO> orderDoList = orderRepository.getOrdersByPaymentMode(paymentMode.name());
		List<OrderModel> orderModelList = new ArrayList<>();
		for (OrderDO odo : orderDoList ) {
			orderModelList.add(mapOrderDOToOrderModel(odo));
		}
		return orderModelList;
	}
	
	public boolean updateOrderStatus(String orderId, OrderStatus status) {
		OrderDO order = orderRepository.getOrderByOrderId(orderId);
		order.setOrderStatus(status);
		OrderDO newOrder = orderRepository.save(order);
		if (newOrder != null)
			return true;
		else 
			return false;
	}
	
	public OrderModel getOrderByOrderId(String orderId) {
		OrderDO orderDo = orderRepository.getOrderByOrderId(orderId);
		return mapOrderDOToOrderModel(orderDo);
	}
	
	public List<OrderModel> getOrderListByOrderIds(List<String> orderIds) {
		List<OrderDO> orderDoList = orderRepository.getOrderListByOrderIds(orderIds);
		List<OrderModel> orderModelList = new ArrayList<>();
		for (OrderDO odo : orderDoList ) {
			orderModelList.add(mapOrderDOToOrderModel(odo));
		}
		return orderModelList;
	}
	
	public List<OrderModel> getAllConfirmedOrders() {
		List<OrderDO> orderDoList = orderRepository.getAllConfirmedOrders();
		List<OrderModel> orderModelList = new ArrayList<>();
		for (OrderDO odo : orderDoList ) {
			orderModelList.add(mapOrderDOToOrderModel(odo));
		}
		return orderModelList;
	}
	
	public List<OrderModel> getAllShippedOrders() {
		List<OrderDO> orderDoList = orderRepository.getAllShippedOrders();
		List<OrderModel> orderModelList = new ArrayList<>();
		for (OrderDO odo : orderDoList ) {
			orderModelList.add(mapOrderDOToOrderModel(odo));
		}
		return orderModelList;
	}
	
	public List<OrderModel> getAllDeliveredOrders() {
		List<OrderDO> orderDoList = orderRepository.getAllDeliveredOrders();
		List<OrderModel> orderModelList = new ArrayList<>();
		for (OrderDO odo : orderDoList ) {
			orderModelList.add(mapOrderDOToOrderModel(odo));
		}
		return orderModelList;
	}
	
	public List<OrderModel> getAllRejectedOrders() {
		List<OrderDO> orderDoList = orderRepository.getAllRejectedOrders();
		List<OrderModel> orderModelList = new ArrayList<>();
		for (OrderDO odo : orderDoList ) {
			orderModelList.add(mapOrderDOToOrderModel(odo));
		}
		return orderModelList;
	}
	
	public List<OrderModel> getAllFailedOrders() {
		List<OrderDO> orderDoList = orderRepository.getAllFailedOrders();
		List<OrderModel> orderModelList = new ArrayList<>();
		for (OrderDO odo : orderDoList ) {
			orderModelList.add(mapOrderDOToOrderModel(odo));
		}
		return orderModelList;
	}
	
	public List<String> getAllPaymentMethodTypes() {
		List<String> types = new ArrayList<>(PaymentMode.values().length);
		for (PaymentMode mode : PaymentMode.values()) {
			types.add(mode.getPaymentType());
		}
		return types;
	}
	
	public List<OrderModel> getAllOrdersByVendorId(String vendorId) {
		List<OrderDO> orderDoList  =orderRepository.getAllOrdersByVendorId(vendorId);
		List<OrderModel> orderModelList = new ArrayList<>();
		for (OrderDO odo : orderDoList ) {
			orderModelList.add(mapOrderDOToOrderModel(odo));
		}
		return orderModelList;
	}
	
	public List<OrderModel> getAllAssignedOrdersByVendorId(String vendorId) {
		List<OrderDO> orderDoList  =orderRepository.getAllAssignedOrdersByVendorId(vendorId);
		List<OrderModel> orderModelList = new ArrayList<>();
		for (OrderDO odo : orderDoList ) {
			orderModelList.add(mapOrderDOToOrderModel(odo));
		}
		return orderModelList;
	}
	
	public List<OrderModel> getAllShippedOrdersByVendorId(String vendorId) {
		List<OrderDO> orderDoList  =orderRepository.getAllShippedOrdersByVendorId(vendorId);
		List<OrderModel> orderModelList = new ArrayList<>();
		for (OrderDO odo : orderDoList ) {
			orderModelList.add(mapOrderDOToOrderModel(odo));
		}
		return orderModelList;
	}
	
	public List<OrderModel> getAllDeliveredOrdersByVendorId(String vendorId) {
		List<OrderDO> orderDoList  =orderRepository.getAllDeliveredOrdersByVendorId(vendorId);
		List<OrderModel> orderModelList = new ArrayList<>();
		for (OrderDO odo : orderDoList ) {
			orderModelList.add(mapOrderDOToOrderModel(odo));
		}
		return orderModelList;
	}
	
	public List<OrderModel> getAllRejectedOrdersByVendorId(String vendorId) {
		List<OrderDO> orderDoList  =orderRepository.getAllRejectedOrdersByVendorId(vendorId);
		List<OrderModel> orderModelList = new ArrayList<>();
		for (OrderDO odo : orderDoList ) {
			orderModelList.add(mapOrderDOToOrderModel(odo));
		}
		return orderModelList;
	}
	
	public List<OrderModel> getAllFailedOrdersByVendorId(String vendorId) {
		List<OrderDO> orderDoList  =orderRepository.getAllFailedOrdersByVendorId(vendorId);
		List<OrderModel> orderModelList = new ArrayList<>();
		for (OrderDO odo : orderDoList ) {
			orderModelList.add(mapOrderDOToOrderModel(odo));
		}
		return orderModelList;
	}
	
	/**
	 * This method get unique order id using Unique Identifier Generator API.
	 * @return
	 */
	private String getNextOrderId() {
		Long nextId = uniqueIdentityProvider.getNextOrderId();
		String nextOrderId = generateIdWithPrefix(orderIdPrefix, nextId);
		return nextOrderId;
	}
	
	private String generateIdWithPrefix(String prefix, Long id) {
		return prefix + "-" + id; 
	}
	
	/**
	 * This method get unique invoice id using Unique Identifier Generator API.
	 * @return
	 */
	private String getNextInvoiceId() {
		Long nextId = uniqueIdentityProvider.getNextInvoiceId();
		String nextOrderId = generateIdWithPrefix(invoiceIdPrefix, nextId);
		return nextOrderId;
	}
	
    //    _._ _..._ .-',     _.._(`))
    //   '-. `     '  /-._.-'    ',/        RANDOM PIG
    //      )         \            '.       Well done, you have
    //     / _    _    |             \      found random pig.
    //    |  a    a    /              |
    //    \   .-.                     ;     It is now your
    //     '-('' ).-'       ,'       ;      responsibility to
    //        '-;           |      .'       insert random pig at
    //           \           \    /         another code location.
    //           | 7  .__  _.-\   \
    //           | |  |  ``/  /`  /         Don't ask me why, I don't
    //          /,_|  |   /,_/   /          make the rules around here.
    //             /,_/      '`-'
	
	/**
	 * This method create or map {@code OrderDO} object by {@code OrderRequest} object.
	 * @param request
	 * @return
	 */
	private OrderDO mapOrderRequestToOrderDO(OrderRequest request) {
		//First Create OrderDO.
		OrderDO odrDO = new OrderDO();
		odrDO.setOrderId(getNextOrderId()); // Get Unique OrderID for each new order. 
		odrDO.setOrderDate(new Date());
		odrDO.setUserId(request.getUserId());
		odrDO.setEmail(request.getEmail());
		odrDO.setContactNumber(request.getContactNumber());
		odrDO.setCustomerName(request.getCustomerName());
		odrDO.setBillTo(request.getBillTo());
		odrDO.setShipTo(request.getShipTo());
		odrDO.setPaymentMode(PaymentMode.valueOf(request.getPaymentMode().toUpperCase()));
		
		//Second Create InvoiceDO.
		InvoiceDO invDO = new InvoiceDO();
		Bill bill = request.getBill();
		invDO.setInvoiceNumber(getNextInvoiceId()); // Get Unique InvoiceID for each new Invoice. 
		invDO.setInvoiceDate(new Date());
		invDO.setContactNumber(bill.getContactNumber());
		invDO.setCustomerName(bill.getCustomerName());
		invDO.setPan(companyPan);
		invDO.setCin(companyCin);
		invDO.setCoupon(bill.getCoupon());
		invDO.setTotalPrice(new BigDecimal(bill.getTotalPrice()).setScale(2, BigDecimal.ROUND_CEILING));
		invDO.setDeliveryCharge(new BigDecimal(bill.getDeliveryCharge()).setScale(2, BigDecimal.ROUND_CEILING));
		invDO.setGst(new BigDecimal(bill.getGst()).setScale(2, BigDecimal.ROUND_CEILING));
		invDO.setCgst(new BigDecimal(bill.getCgst()).setScale(2, BigDecimal.ROUND_CEILING));
		invDO.setSgst(new BigDecimal(bill.getSgst()).setScale(2, BigDecimal.ROUND_CEILING));
		invDO.setCouponDiscount(new BigDecimal(bill.getCouponDiscount()).setScale(2, BigDecimal.ROUND_CEILING));
		invDO.setPayable(new BigDecimal(bill.getPayable()).setScale(2, BigDecimal.ROUND_CEILING));
		
		//Thread Create Items List.
		List<ItemDO> itemDOList = new ArrayList<>();
		List<Item> itemsList = bill.getItemsList();
		for (Item i : itemsList) {
			ItemDO ido = new ItemDO();
			BeanUtils.copyProperties(i, ido);
			ido.setPrice(new BigDecimal(i.getPrice()));
			itemDOList.add(ido);
		}
		
		//Fourth set ItemDO list in InvoiceDO.
		invDO.setItemsList(itemDOList);
		
		//Sixth set InvoiceDO in OrderDO.
		odrDO.setInvoice(invDO);
		
		return odrDO;
	}
	
	/**
	 * This method create or map {@code OrderModel} object by {@code OrderDO} Object.
	 * @param orderDO
	 * @return
	 */
	private OrderModel mapOrderDOToOrderModel(OrderDO orderDO) {
		if (orderDO == null) 
			return null;
		
		OrderModel orderModel = new OrderModel();
		InvoiceModel invoiceModel = new InvoiceModel();
		BeanUtils.copyProperties(orderDO, orderModel);
		BeanUtils.copyProperties(orderDO.getInvoice(), invoiceModel);
		orderModel.setInvoice(invoiceModel);
		return orderModel;
	}

}
