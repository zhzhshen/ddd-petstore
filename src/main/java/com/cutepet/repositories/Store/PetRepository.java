package com.cutepet.repositories.Store;

import com.cutepet.domain.Store.PetInStore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<PetInStore, Long> {

    List<PetInStore> findByStoreId(long storeId);
    PetInStore findByIdAndStoreId(long id, long storeId);
}
