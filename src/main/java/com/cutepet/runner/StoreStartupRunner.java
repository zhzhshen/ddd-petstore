package com.cutepet.runner;

import com.cutepet.domain.Common.PaymentMethod;
import com.cutepet.domain.Common.PetType;
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

        // Create some stores
        storeRepository.save(new Store("Dogy"));
        storeRepository.save(new Store("Wolfy"));
        storeRepository.save(new Store("Caty"));
        storeRepository.save(new Store("Birdy"));
        storeRepository.save(new Store("Sheepy"));

        // Put some pets in store
        long id;
        List<PaymentMethod> payOnline = new ArrayList<>();
        payOnline.add(PaymentMethod.PAY_ON_DELIVERY);

        id = storeRepository.findByName("Dogy").get(0).getId();
        storePetRepository.save(new Pet(id, "Dog1", "Black", PetType.DOG_HUSKIE, payOnline));
        storePetRepository.save(new Pet(id, "Dog2", "Yellow", PetType.DOG_OTHER, payOnline));

        id = storeRepository.findByName("Wolfy").get(0).getId();
        storePetRepository.save(new Pet(id, "Dog3", "White", PetType.DOG_HUSKIE, payOnline));

        id = storeRepository.findByName("Caty").get(0).getId();
        storePetRepository.save(new Pet(id, "Cat1", "Black", PetType.CAT_OTHER, payOnline));

        id = storeRepository.findByName("Birdy").get(0).getId();
        storePetRepository.save(new Pet(id, "Bird1", "Blue", PetType.BIRD_OTHER, payOnline));

    }
}
