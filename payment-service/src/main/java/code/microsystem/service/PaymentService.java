package code.microsystem.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import code.microsystem.entity.Payment;
import code.microsystem.repositroy.PaymentRepositroy;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepositroy paymentRepositroy;
	
	public Payment doPayment(Payment payment) {
		payment.setPaymentStatus(paymentProcessing());
		payment.setTrancationId(UUID.randomUUID().toString());
		return paymentRepositroy.save(payment);
	}
	
	public String paymentProcessing() {
		return new Random().nextBoolean()?"success":"false";
	}

	public Payment findPaymentHistoryByOrderId(int orderId) {
		
		return paymentRepositroy.findByOrderId(orderId);
	}
}
