package code.microsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import code.microsystem.common.Payment;
import code.microsystem.dto.TranscationRequest;
import code.microsystem.dto.TranscationResponse;
import code.microsystem.entity.Order;
import code.microsystem.repositroy.OrderRepositroy;

@Service
public class OrderService {

	@Autowired
	private OrderRepositroy orderRepositroy;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public TranscationResponse saveOrder(TranscationRequest request) {
		String response="";
		Order order=request.getOrder();
		Payment payment=request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		//rest Call
		Payment paymentResponse=restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment,Payment.class);
		response=paymentResponse.getPaymentStatus().equals("success")?"Payment Processing Successful":"There is failure in Payment";
		orderRepositroy.save(order);
		 
		 return new TranscationResponse(order,paymentResponse.getTrancationId(),paymentResponse.getAmount(),response);
	}
}
