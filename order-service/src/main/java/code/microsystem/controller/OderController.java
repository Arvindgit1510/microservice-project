package code.microsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import code.microsystem.common.Payment;
import code.microsystem.dto.TranscationRequest;
import code.microsystem.dto.TranscationResponse;
import code.microsystem.entity.Order;
import code.microsystem.service.OrderService;

@RestController
@RequestMapping("/order")
public class OderController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/bookorder")
	public TranscationResponse bookOrder(@RequestBody TranscationRequest request) {
		
		
		return orderService.saveOrder(request);
	}

}
