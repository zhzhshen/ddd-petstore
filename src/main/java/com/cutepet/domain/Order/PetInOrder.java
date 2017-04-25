package com.cutepet.domain.Order;

import com.cutepet.domain.Common.PaymentMethod;
import com.cutepet.domain.Common.PetType;

import javax.persistence.*;

@Entity
@Table(name = "PetInOrder")
public class PetInOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String color;
    private PetType type;
    private PaymentMethod paymentMethod;
    private Long orderId;

    public PetInOrder() {

    }

    public PetInOrder(String name, String color, PetType type, PaymentMethod paymentMethod, Long orderId) {
        this.name = name;
        this.color = color;
        this.type = type;
        this.paymentMethod = paymentMethod;
        this.orderId = orderId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
