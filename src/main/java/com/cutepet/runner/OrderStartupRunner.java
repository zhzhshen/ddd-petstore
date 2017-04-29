package com.cutepet.runner;

import com.cutepet.persistence.common.PaymentMethod;
import com.cutepet.persistence.common.PetType;
import com.cutepet.persistence.entity.order.Customer;
import com.cutepet.persistence.entity.order.Order;
import com.cutepet.persistence.entity.order.PetInOrder;
import com.cutepet.persistence.repositories.order.OrderRepository;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;


@Component
public class OrderStartupRunner implements CommandLineRunner {

    @Autowired
    OrderRepository orderRepository;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    @Override
    public void run(String...args) throws Exception {

        List<PetInOrder> petList1 = ImmutableList.of(
                new PetInOrder("Dog1", "Brown", PetType.DOG_OTHER, PaymentMethod.PAY_ON_DELIVERY),
                new PetInOrder("Cat1", "White", PetType.CAT_OTHER, PaymentMethod.PAY_ON_LINE)
        );
        List<PetInOrder> petList2 = ImmutableList.of(
                new PetInOrder("Bird1", "Yellow", PetType.BIRD_OTHER, PaymentMethod.PAY_ON_LINE)
        );

        Customer customer1 = new Customer("John Smith", "12345678");
        Customer customer2 = new Customer("Tom Mate", "12345678");

        // Create some orders
        orderRepository.save(ImmutableList.of(
                new Order(dateFormat.parse("2017-04-04T12:08:56.235+0800"), 1L, petList1, customer1),
                new Order(dateFormat.parse("2017-04-24T15:46:25.462+0800"), 2L, petList2, customer2)
        ));

    }
}
