package code.microsystem.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import code.microsystem.entity.Payment;

public interface PaymentRepositroy extends JpaRepository<Payment, Integer> {

	Payment findByOrderId(int orderId);

}
