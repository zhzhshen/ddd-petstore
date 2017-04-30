package com.cutepet.domain.store;

import com.cutepet.utils.ContextHolder;
import com.cutepet.persistence.entity.store.PetEntity;
import com.cutepet.persistence.entity.store.StoreEntity;
import com.cutepet.persistence.repositories.store.PetInStoreRepository;
import com.cutepet.persistence.repositories.store.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Store {

    private final long storeId;

    @Autowired
    PetInStoreRepository petRepository;

    public Store(long id) {
        this.storeId = id;
    }

    public static List<StoreEntity> getAllStores() {
        return ContextHolder.getContext().getBean(StoreRepository.class).findAll();
    }

    public List<PetEntity> getPets() {
        return petRepository.findByStoreId(storeId);
    }


    public PetEntity getPet(long pet_id) {
        return petRepository.findByIdAndStoreId(pet_id, storeId);
    }
}
