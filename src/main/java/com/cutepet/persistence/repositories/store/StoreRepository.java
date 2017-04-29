package com.cutepet.persistence.repositories.store;

import com.cutepet.persistence.entity.store.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StoreRepository extends JpaRepository<StoreEntity, Long> {

    List<StoreEntity> findByName(String name);
}
