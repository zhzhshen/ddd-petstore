package com.cutepet.persistence.repositories.store;

import com.cutepet.persistence.entity.store.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetInStoreRepository extends JpaRepository<PetEntity, Long> {

    List<PetEntity> findByStoreId(long storeId);
    PetEntity findByIdAndStoreId(long id, long storeId);
}
