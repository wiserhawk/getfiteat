package com.indhawk.getfiteat.payment.service;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indhawk.getfiteat.payment.dataobj.PaymentDO;
import com.indhawk.getfiteat.payment.model.PaymentCallback;
import com.indhawk.getfiteat.payment.model.PaymentDetail;
import com.indhawk.getfiteat.payment.mongodb.repository.PaymentRepository;
import com.indhawk.getfiteat.payment.response.PaymentDetailResponse;
import com.indhawk.getfiteat.payment.util.PaymentStatus;
import com.indhawk.getfiteat.payment.util.PaymentUtil;

@Service
public class PayUMoneyServiceImpl implements PaymentService {

	@Autowired
	PaymentRepository paymentRepository;
	
	@Override
	public PaymentDetailResponse proceedPayment(PaymentDetail paymentDetail) {
		paymentDetail = PaymentUtil.populatePaymentDetail(paymentDetail);
		savePaymentDetail(paymentDetail);
		PaymentDetailResponse paymentRes = new PaymentDetailResponse();
		return copyBeanProperties(paymentDetail, paymentRes);
	}

	@Override
	public String payuCallback(PaymentCallback paymentResponse) {
		String msg = "FAILED";
		PaymentDO payment = paymentRepository.getPaymentByTxnId(paymentResponse.getTxnid());
		if (payment != null) {
			// TODO validate the hash
			PaymentStatus paymentStatus = null;
			if (paymentResponse.getStatus().equals("failure")) {
				paymentStatus = PaymentStatus.Failed;
			} else if (paymentResponse.getStatus().equals("success")) {
				paymentStatus = PaymentStatus.Success;
				msg = "SUCCESS";
			}
			payment.setPaymentStatus(paymentStatus);
			payment.setMihpayId(paymentResponse.getMihpayid());
			payment.setMode(paymentResponse.getMode());
			paymentRepository.save(payment);
		}
		return msg;
	}
	
	private PaymentDO savePaymentDetail(PaymentDetail paymentDetail) {
		PaymentDO payment = new PaymentDO();
		payment.setAmount(Double.parseDouble(paymentDetail.getAmount()));
		payment.setEmail(paymentDetail.getEmail());
		payment.setName(paymentDetail.getName());
		payment.setPaymentDate(new Date());
		payment.setPaymentStatus(PaymentStatus.Pending);
		payment.setPhone(paymentDetail.getPhone());
		payment.setProductInfo(paymentDetail.getProductInfo().toString());
		payment.setTxnId(paymentDetail.getTxnId());
		return paymentRepository.save(payment);
	}
	
	private PaymentDetailResponse copyBeanProperties(PaymentDetail src, PaymentDetailResponse dest) {
		BeanUtils.copyProperties(src, dest);
		dest.setProductInfo(src.getProductInfo().toString());
		return dest;
	}

}
