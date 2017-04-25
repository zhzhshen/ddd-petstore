package com.cutepet.repositories.Order;

import com.cutepet.domain.Order.PetInOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetInOrderRepository extends JpaRepository<PetInOrder, Long> {

    List<PetInOrder> findByOrderId(Long orderId);
}
