package com.cutepet.domain.Order;

import javax.persistence.*;
import java.util.Date;

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

    public Order() {
    }

    public Order(Date orderTime, Long userId) {
        this.orderTime = orderTime;
        this.userId = userId;
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
}
