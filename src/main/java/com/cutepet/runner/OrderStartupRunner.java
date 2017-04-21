package com.cutepet.runner;

import com.cutepet.domain.Common.PaymentMethod;
import com.cutepet.domain.Common.PetType;
import com.cutepet.domain.Order.Order;
import com.cutepet.domain.Order.Pet;
import com.cutepet.repositories.Order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@Component
public class OrderStartupRunner implements CommandLineRunner {

    @Autowired
    OrderRepository orderRepository;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    @Override
    public void run(String...args) throws Exception {

        // Create some orders
        List<Pet> pets = new ArrayList<>();
        pets.add(new Pet("Dog1", "Brown", PetType.DOG_OTHER, PaymentMethod.PAY_ON_DELIVERY));
        orderRepository.save(new Order(dateFormat.parse("2017-04-04T12:08:56.235+0800"), 1, pets));
    }
}
