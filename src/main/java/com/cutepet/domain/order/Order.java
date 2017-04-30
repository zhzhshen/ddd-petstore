package com.cutepet.domain.order;

import com.cutepet.persistence.common.PaymentMethod;
import com.cutepet.persistence.common.PetType;
import com.cutepet.persistence.entity.order.CustomerEntity;
import com.cutepet.persistence.entity.order.OrderEntity;
import com.cutepet.persistence.entity.order.PetEntity;
import com.cutepet.persistence.repositories.order.OrderRepository;
import com.cutepet.utils.ContextHolder;
import com.cutepet.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class Order {

    @Autowired
    OrderRepository orderRepository;
    private Long userId;
    private List<PetEntity> pets;
    private CustomerEntity customer;

    public Order() {
    }

    public void addPet(String name, String color, PetType type, PaymentMethod payment) {
        pets.add(new PetEntity(name, color, type, payment));
    }

    public void save() {
        orderRepository.save(new OrderEntity(new Date(), userId, pets, customer));
    }

    public static Order createOrder(Long userId, String name, String phoneNum) {
        Order order = new Order();
        order.userId = userId;
        order.customer = new CustomerEntity(name, phoneNum);
        order.pets = new ArrayList<>();
        return order;
    }

    public static List<Map<String, Object>> getAllOrders() {
        List<Map<String, Object>> orderList = new ArrayList<>();
        List<OrderEntity> orders = ContextHolder.getContext().getBean(OrderRepository.class).findAll();
        orders.forEach((order -> {
            List<PetEntity> pets = order.getPets();
            Map<String, Object> orderMap = Utils.introspect(order);
            orderMap.put("pets", pets);
            orderList.add(orderMap);
        }));
        return orderList;
    }

    public static Map<String, Object> getOrder(long order_id) {
        Map<String, Object> orderMap = null;
        try {
            OrderEntity order = ContextHolder.getContext()
                    .getBean(OrderRepository.class).findById(order_id).get(0);
            List<PetEntity> pets = order.getPets();
                orderMap = Utils.introspect(order);
                orderMap.put("pets", pets);
        } catch (IndexOutOfBoundsException e) {
            orderMap = new HashMap<>();
        }
        return orderMap;
    }

}
