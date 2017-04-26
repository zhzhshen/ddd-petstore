package com.cutepet.domain.Order;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "OrderTable")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "orderTime")
    @Temporal(TemporalType.TIME)
    private Date orderTime;
    @Column(name = "userId")
    private Long userId;
    @ElementCollection
    @CollectionTable(
            name = "ORDER_PETS",
            joinColumns = @JoinColumn(name = "ORDER_ID")
    )
    private List<PetInOrder> pets;

    public Order() {
    }

    public Order(Date orderTime, Long userId, List<PetInOrder> pets) {
        this.orderTime = orderTime;
        this.userId = userId;
        this.pets = pets;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<PetInOrder> getPets() {
        return pets;
    }
}
