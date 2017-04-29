package com.cutepet.persistence.repositories.order;

import com.cutepet.persistence.entity.order.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findById(long id);
}
