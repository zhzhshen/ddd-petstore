package com.cutepet.repositories.Store;

import com.cutepet.domain.Store.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StoreRepository extends JpaRepository<Store, Long> {

    List<Store> findByName(String name);
}
