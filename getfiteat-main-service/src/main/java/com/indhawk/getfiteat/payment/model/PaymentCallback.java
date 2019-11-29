package com.indhawk.getfiteat.payment.model;

import com.indhawk.getfiteat.payment.util.PaymentMode;

public class PaymentCallback {

    private String txnid;
    
    private String mihpayid;
    
    private PaymentMode mode;
    
    private String status;
    
    private String hash;

	public PaymentCallback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTxnid() {
		return txnid;
	}

	public void setTxnid(String txnid) {
		this.txnid = txnid;
	}

	public String getMihpayid() {
		return mihpayid;
	}

	public void setMihpayid(String mihpayid) {
		this.mihpayid = mihpayid;
	}

	public PaymentMode getMode() {
		return mode;
	}

	public void setMode(PaymentMode mode) {
		this.mode = mode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	@Override
	public String toString() {
		return "PayUMoneyPaymentCallback [txnid=" + txnid + ", mihpayid=" + mihpayid + ", mode=" + mode + ", status="
				+ status + ", hash=" + hash + "]";
	}
    
    
}
