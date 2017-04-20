package com.cutepet.repositories.Store;

import com.cutepet.domain.Store.Pet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PetRepository extends CrudRepository<Pet, Long> {

    List<Pet> findByStoreId(long storeId);
    Pet findByIdAndStoreId(long id, long storeId);
}
