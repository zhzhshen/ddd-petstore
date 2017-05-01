package com.cutepet.domain.order;

import com.cutepet.persistence.entity.order.OrderEntity;
import com.cutepet.persistence.repositories.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Order {

    @Autowired
    OrderRepository orderRepository;

    public Order() {
    }

    public void createOrder(OrderEntity orderEntity) {
        orderRepository.save(orderEntity);
    }

    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderEntity getOrder(long order_id) {
        return orderRepository.findById(order_id).get(0);
    }

}
