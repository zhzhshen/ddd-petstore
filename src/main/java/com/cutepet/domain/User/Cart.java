package com.cutepet.domain.User;

import java.util.List;

public class Cart {

    private long id;
    private List<Pet> petList;

    public String getId() {
        long id;
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public void addPet(Pet pet) {
        this.petList.add(pet);
    }

    public void removePet(Pet pet) {
        this.petList.remove(pet);
    }

}
