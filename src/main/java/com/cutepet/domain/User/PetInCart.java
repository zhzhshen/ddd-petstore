package com.cutepet.domain.User;

import javax.persistence.*;

@Entity
@Table(name = "PetInCart")
public class PetInCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Long storeId;
    private Long petId;
    private Long cartId;

    public PetInCart() {

    }

    public PetInCart(Long storeId, Long petId, Long cartId) {
        this.storeId = storeId;
        this.petId = petId;
        this.cartId = cartId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }
}
