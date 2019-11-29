package com.indhawk.order.dataobj;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="InvoiceNumbers")
public class InvoiceNumberDO {
	
	@Id
	private long invoiceNumber;
	
	private boolean isInvoiceNumberUsed;
	
	public InvoiceNumberDO() {
		super();
	}

	public InvoiceNumberDO(long invoiceNumber, boolean isInvoiceNumberUsed) {
		super();
		this.invoiceNumber = invoiceNumber;
		this.isInvoiceNumberUsed = isInvoiceNumberUsed;
	}

	public long getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public boolean isInvoiceNumberUsed() {
		return isInvoiceNumberUsed;
	}

	public void setInvoiceNumberUsed(boolean isInvoiceNumberUsed) {
		this.isInvoiceNumberUsed = isInvoiceNumberUsed;
	}

	@Override
	public String toString() {
		return "InvoiceNumberDO [invoiceNumber=" + invoiceNumber + ", isInvoiceNumberUsed=" + isInvoiceNumberUsed + "]";
	}
	
}
