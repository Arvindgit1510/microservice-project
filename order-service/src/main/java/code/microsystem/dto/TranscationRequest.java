package code.microsystem.dto;

import code.microsystem.common.Payment;
import code.microsystem.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TranscationRequest {
	private Payment payment;
	private Order order;

}
