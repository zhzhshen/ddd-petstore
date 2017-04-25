package com.cutepet.repositories.Order;

import com.cutepet.domain.Order.PetInOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetInOrderRepository extends JpaRepository<PetInOrder, Long> {

}
