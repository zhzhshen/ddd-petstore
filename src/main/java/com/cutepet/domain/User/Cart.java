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
    private long userId;

    public Cart() {
    }

    public Cart(long userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

}
