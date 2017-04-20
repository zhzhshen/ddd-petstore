package com.cutepet.domain.Store;

import javax.persistence.*;

@Entity
@Table(name = "Store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    public Store() {
    }

    public Store(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format(
                "Store[id=%d, namee='%s']",
                id, name);
    }
}
