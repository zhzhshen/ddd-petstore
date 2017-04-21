package com.cutepet.domain.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ElementCollection
    private List<Pet> petList;
    private long userId;

    public Cart() {
    }

    public Cart(long userId) {
        this.petList = new ArrayList<>();
        this.userId = userId;
    }

    public long getId() {
        return id;
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
