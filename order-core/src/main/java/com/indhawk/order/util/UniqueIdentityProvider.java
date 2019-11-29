package com.indhawk.order.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.indhawk.unique.sequence.invoice.InvoiceUniqueSequenceGenerator;
import com.indhawk.unique.sequence.order.OrderUniqueSequenceGenerator;
import com.indhawk.order.dataobj.InvoiceNumberDO;
import com.indhawk.order.dataobj.OrderNumberDO;
import com.indhawk.order.repository.InvoiceNumberRepository;
import com.indhawk.order.repository.OrderNumberRepository;

@Component
public class UniqueIdentityProvider {
	
	@Autowired
	private OrderNumberRepository orderNumberRepository;
	
	@Autowired
	private InvoiceNumberRepository invoiceNumberRepository;
	
	private static OrderUniqueSequenceGenerator ORDER_UNIQUE_SEQUENCE_GENERATOR; 
	
	private static InvoiceUniqueSequenceGenerator INVOICE_UNIQUE_SEQUENCE_GENERATOR;
	
	private static volatile boolean initialized = false; 
	
	
	public UniqueIdentityProvider() {
		
	}
	
	private synchronized void init() {
		if (!initialized) {
			OrderNumberDO orderNumDO = orderNumberRepository.findFirstByOrderByOrderNumberDesc();
			Long maxOrderNumber = (orderNumDO != null) ? orderNumDO.getOrderNumber() + 1 : null;
			InvoiceNumberDO invoiceNumDo = invoiceNumberRepository.findTopByOrderByInvoiceNumberDesc();
			Long maxInvoiceNumber = (invoiceNumDo != null) ? invoiceNumDo.getInvoiceNumber() + 1 : null;
			ORDER_UNIQUE_SEQUENCE_GENERATOR = OrderUniqueSequenceGenerator.getInstance(maxOrderNumber);
			INVOICE_UNIQUE_SEQUENCE_GENERATOR = InvoiceUniqueSequenceGenerator.getInstance(maxInvoiceNumber);
			initialized = true;
		}
	}

	public String getUniqueOrderId() {
		init();
		return ORDER_UNIQUE_SEQUENCE_GENERATOR.getNextOrderId();
	}

	public String getUniqueInvoiceId() {
		init();
		return INVOICE_UNIQUE_SEQUENCE_GENERATOR.getNextInvoiceId();
	}

}
