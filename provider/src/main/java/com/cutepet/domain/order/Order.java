package com.cutepet.domain.order;

import com.cutepet.persistence.entity.order.OrderEntity;
import com.cutepet.persistence.repositories.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Order {

    @Autowired
    OrderRepository orderRepository;

    public Order() {
    }

    public boolean createOrder(OrderEntity orderEntity) {
        orderRepository.save(orderEntity);
        return true;
    }

    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderEntity getOrder(long order_id) {
        return orderRepository.findById(order_id).get(0);
    }

}
