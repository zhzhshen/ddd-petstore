package com.cutepet.repositories.Store;

import com.cutepet.domain.Store.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findByStoreId(long storeId);
    Pet findByIdAndStoreId(long id, long storeId);
}
