package com.cutepet.persistence.entity.store;

import javax.persistence.*;

@Entity
@Table(name = "StoreEntity")
public class StoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    public StoreEntity() {
    }

    public StoreEntity(String name) {
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
        return String.format("StoreEntity[id=%d, namee='%s']", id, name);
    }
}
