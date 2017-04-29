package com.cutepet.persistence.repositories.store;

import com.cutepet.persistence.entity.store.PetInStore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetInStoreRepository extends JpaRepository<PetInStore, Long> {

    List<PetInStore> findByStoreId(long storeId);
    PetInStore findByIdAndStoreId(long id, long storeId);
}
