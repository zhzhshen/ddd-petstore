package com.cutepet.domain.store;

import com.cutepet.persistence.entity.store.PetEntity;
import com.cutepet.persistence.entity.store.StoreEntity;
import com.cutepet.persistence.repositories.store.PetInStoreRepository;
import com.cutepet.persistence.repositories.store.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Store {

    @Autowired
    StoreRepository storeRepository;
    @Autowired
    PetInStoreRepository petRepository;

    public List<StoreEntity> getAllStores() {
        return storeRepository.findAll();
    }

    public StoreEntity getStore(Long storeId) {
        return storeRepository.findById(storeId).get(0);
    }

    public List<PetEntity> getAllPetsInStore(StoreEntity storeEntity) {
        return petRepository.findByStoreId(storeEntity.getId());
    }


    public PetEntity getPetInStore(StoreEntity storeEntity, Long pet_id) {
        return petRepository.findByIdAndStoreId(pet_id, storeEntity.getId());
    }
}
