package com.indhawk.unique.sequence.invoice;

import com.indhawk.unique.sequence.SimpleUniqueSequenceBuilder;
import com.indhawk.unique.sequence.UniqueSequenceBuilder;

public class InvoiceUniqueSequenceGenerator {

	private static UniqueSequenceBuilder<Long> sequenceBuilder;
	
	private static final String INVOICE_PREFIX = "IN-";
	
	private static volatile boolean init = false;
	
	private volatile static InvoiceUniqueSequenceGenerator instance; 
	
	private InvoiceUniqueSequenceGenerator() {
		
	}
	
	public static synchronized InvoiceUniqueSequenceGenerator getInstance(Long initailID) {
		if (!init) {
			instance = new InvoiceUniqueSequenceGenerator();
			if (initailID == null) 
				sequenceBuilder = new SimpleUniqueSequenceBuilder();
			else
				sequenceBuilder = new SimpleUniqueSequenceBuilder(initailID);
			init = true;
		}
		return instance;
	}
	
	public String getNextInvoiceId() {
		StringBuilder invoiceId = new StringBuilder(INVOICE_PREFIX);
		invoiceId.append(sequenceBuilder.getNextId());
		return invoiceId.toString();
	}
}
