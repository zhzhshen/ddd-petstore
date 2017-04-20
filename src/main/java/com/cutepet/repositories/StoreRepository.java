package com.cutepet.repositories;

import java.util.List;

import com.cutepet.domain.Store.Store;
import org.springframework.data.repository.CrudRepository;


public interface StoreRepository extends CrudRepository<Store, Long> {

    List<Store> findByName(String name);
}
