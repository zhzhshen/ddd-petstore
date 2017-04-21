package com.cutepet.repositories.Order;

import com.cutepet.domain.Order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findById(long id);
}
