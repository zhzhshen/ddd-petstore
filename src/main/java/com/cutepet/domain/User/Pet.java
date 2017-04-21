package com.cutepet.domain.User;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pet {

    private Long storeId;
    private Long petId;

    public Pet(Long storeId, Long petId) {
        this.storeId = storeId;
        this.petId = petId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    @Id
    public String getId() {
        return String.valueOf(petId);
    }
    @Id
    public void setId(String id) {
    }

}
