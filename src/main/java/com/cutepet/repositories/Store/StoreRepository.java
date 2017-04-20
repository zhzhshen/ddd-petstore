package com.cutepet.repositories.Store;

import com.cutepet.domain.Store.Store;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface StoreRepository extends CrudRepository<Store, Long> {

    List<Store> findByName(String name);
}
