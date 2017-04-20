package com.cutepet.runner;

import com.cutepet.domain.Common.PaymentMethod;
import com.cutepet.domain.Store.Pet;
import com.cutepet.domain.Store.Store;
import com.cutepet.repositories.Store.PetRepository;
import com.cutepet.repositories.Store.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class StoreStartupRunner implements CommandLineRunner {

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    PetRepository storePetRepository;

    @Override
    public void run(String...args) throws Exception {

        // save a couple of customers
        storeRepository.save(new Store("Jack"));
        storeRepository.save(new Store("Chloe"));
        storeRepository.save(new Store("Kim"));
        storeRepository.save(new Store("Palmer"));
        storeRepository.save(new Store("Michelle"));

        long id = storeRepository.findByName("Jack").get(0).getId();
        List paymentMethods = new ArrayList();
        paymentMethods.add(PaymentMethod.PAY_ON_DELIVERY);
        storePetRepository.save(new Pet(id, "Dog", "Black", paymentMethods));
    }
}
