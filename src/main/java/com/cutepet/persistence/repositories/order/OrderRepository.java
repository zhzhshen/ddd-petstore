package com.cutepet.persistence.repositories.order;

import com.cutepet.persistence.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findById(long id);
}
