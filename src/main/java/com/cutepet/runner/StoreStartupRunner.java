package com.cutepet.runner;

import com.cutepet.domain.Common.PaymentMethod;
import com.cutepet.domain.Common.PetType;
import com.cutepet.domain.Store.PetInStore;
import com.cutepet.domain.Store.Store;
import com.cutepet.repositories.Store.PetInStoreRepository;
import com.cutepet.repositories.Store.StoreRepository;
import com.google.common.collect.Lists;
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
    PetInStoreRepository storePetRepository;

    @Override
    public void run(String...args) throws Exception {

        // Create some stores
        storeRepository.save(Lists.newArrayList(new Store("Dogy"),
                new Store("Wolfy"),
                new Store("Caty"),
                new Store("Birdy"),
                new Store("Sheepy")));

        // Put some pets in store
        long id;
        List<PaymentMethod> payOnline = new ArrayList<>();
        payOnline.add(PaymentMethod.PAY_ON_DELIVERY);

        id = storeRepository.findByName("Dogy").get(0).getId();
        storePetRepository.save(new PetInStore("Dog1", "Black", PetType.DOG_HUSKIE, payOnline, id));
        storePetRepository.save(new PetInStore("Dog2", "Yellow", PetType.DOG_OTHER, payOnline, id));

        id = storeRepository.findByName("Wolfy").get(0).getId();
        storePetRepository.save(new PetInStore("Dog3", "White", PetType.DOG_HUSKIE, payOnline, id));

        id = storeRepository.findByName("Caty").get(0).getId();
        storePetRepository.save(new PetInStore("Cat1", "Black", PetType.CAT_OTHER, payOnline, id));

        id = storeRepository.findByName("Birdy").get(0).getId();
        storePetRepository.save(new PetInStore("Bird1", "Blue", PetType.BIRD_OTHER, payOnline, id));

    }
}
