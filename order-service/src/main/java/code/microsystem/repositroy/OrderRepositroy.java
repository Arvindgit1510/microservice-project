package code.microsystem.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import code.microsystem.entity.Order;

public interface OrderRepositroy extends JpaRepository<Order, Integer>{

}
