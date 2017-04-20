package com.cutepet.domain.Order;

import java.util.Date;
import java.util.List;

public class Order {

    private long id;
    private Date orderTime;
    private String userId;
    private List<Pet> pets;

    public long getId() {
        return id;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public String getUserId() {
        return userId;
    }

    public List<Pet> getPets() {
        return pets;
    }
}
