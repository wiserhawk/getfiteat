package com.indhawk.getfiteat.order.util;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//import com.indhawk.unique.sequence.invoice.InvoiceUniqueSequenceGenerator;
//import com.indhawk.unique.sequence.order.OrderUniqueSequenceGenerator;
import com.indhawk.getfiteat.order.dataobj.InvoiceNumberDO;
import com.indhawk.getfiteat.order.dataobj.OrderDO;
import com.indhawk.getfiteat.order.dataobj.OrderNumberDO;
import com.indhawk.getfiteat.order.repository.InvoiceNumberRepository;
import com.indhawk.getfiteat.order.repository.OrderNumberRepository;
import com.indhawk.getfiteat.order.repository.OrderRepository;

@Component
public class UniqueIdentityProvider {
	
	@Autowired
	private OrderNumberRepository orderNumberRepository;
	
	@Autowired
	private InvoiceNumberRepository invoiceNumberRepository;
	
	//private static OrderUniqueSequenceGenerator ORDER_UNIQUE_SEQUENCE_GENERATOR; 
	
	//private static InvoiceUniqueSequenceGenerator INVOICE_UNIQUE_SEQUENCE_GENERATOR;
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	private static final int PRE_LOAD_COUNT = 200;
	
	//private static volatile boolean initialized = false; 
	
	private static final Queue<Long> ORDER_NUMBER_QUEUE = new LinkedBlockingQueue<Long>(PRE_LOAD_COUNT); 
	
	private static final Queue<Long> INVOICE_NUMBER_QUEUE = new LinkedBlockingQueue<Long>(PRE_LOAD_COUNT); 
	
	//private static final UniqueIdentityProvider INSTANCE = new UniqueIdentityProvider();
	
	
	public UniqueIdentityProvider() {
		super();
	}
	
	/*private synchronized void init() {
		if (!initialized) {
			
			Long lastOrderId = INSTANCE.getLatestOrderId();
			loadQueue(ORDER_NUMBER_QUEUE, lastOrderId);
			
			Long lastInvoieId = INSTANCE.getLatestInvoiceId();
			loadQueue(INVOICE_NUMBER_QUEUE, lastInvoieId);
			
			initialized = true;
		}
	}*/
	
	public Long getLatestOrderId() {
		OrderNumberDO orderNum = orderNumberRepository.findTopByOrderByOrderNumberDesc();
		if (orderNum == null) {
			// Considering first order of system.
			return 0L;
		}
		return orderNum.getOrderNumber();
	}

	public Long getLatestInvoiceId() {
		InvoiceNumberDO invoiceNumDo = invoiceNumberRepository.findTopByOrderByInvoiceNumberDesc();
		if (invoiceNumDo == null) {
			// Considering first invoice of system.
			return 0L;
		}
		return invoiceNumDo.getInvoiceNumber();
	}
	
	public Long getNextOrderId() {
		if (ORDER_NUMBER_QUEUE.isEmpty()) {
			Long lastOrderId = getLatestOrderId();
			loadQueue(ORDER_NUMBER_QUEUE, lastOrderId);
		}
		return ORDER_NUMBER_QUEUE.poll();
	}
	
	public Long getNextInvoiceId() {
		if (INVOICE_NUMBER_QUEUE.isEmpty()) {
			Long lastInvoiceId = getLatestInvoiceId();
			loadQueue(INVOICE_NUMBER_QUEUE, lastInvoiceId);
		}
		return INVOICE_NUMBER_QUEUE.poll();
	}
	
	private synchronized void loadQueue(Queue<Long> queue, Long startNumber) {
		Long nextNumber = startNumber + 1; 
		for (int i = 0; i < PRE_LOAD_COUNT; i++) {
			queue.add(nextNumber);
			nextNumber++;
		}		
	}

}
