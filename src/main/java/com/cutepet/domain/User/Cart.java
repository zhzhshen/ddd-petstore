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
    private List<PetInCart> petList;
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

    public List<PetInCart> getPetList() {
        return petList;
    }

    public void addPet(PetInCart pet) {
        this.petList.add(pet);
    }

    public void removePet(PetInCart pet) {
        this.petList.remove(pet);
    }

}
