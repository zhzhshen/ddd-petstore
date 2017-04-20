package com.cutepet.runner;

import com.cutepet.domain.Store.Store;
import com.cutepet.repositories.StoreRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;


@Component
public class StoreStartupRunner implements CommandLineRunner {

    @Autowired
    StoreRepository repository;

    @Override
    public void run(String...args) throws Exception {

        // save a couple of customers
        repository.save(new Store("Jack"));
        repository.save(new Store("Chloe"));
        repository.save(new Store("Kim"));
        repository.save(new Store("Palmer"));
        repository.save(new Store("Michelle"));

    }
}
