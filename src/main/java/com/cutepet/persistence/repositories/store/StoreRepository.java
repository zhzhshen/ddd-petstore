package com.cutepet.persistence.repositories.store;

import com.cutepet.persistence.entity.store.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StoreRepository extends JpaRepository<Store, Long> {

    List<Store> findByName(String name);
}
