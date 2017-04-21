package com.cutepet.domain.Order;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date orderTime;
    private long userId;
    @ElementCollection
    private List<Pet> pets;

    public Order() {
    }

    public Order(Date orderTime, long userId, List<Pet> pets) {
        this.orderTime = orderTime;
        this.userId = userId;
        this.pets = pets;
    }

    public long getId() {
        return id;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public long getUserId() {
        return userId;
    }

    public List<Pet> getPets() {
        return pets;
    }
}
