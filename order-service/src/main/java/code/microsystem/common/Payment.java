package code.microsystem.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

	
	private int paymentId;
	private String paymentStatus;
	private String trancationId;
	private int orderId;
	private double amount;
	
}
