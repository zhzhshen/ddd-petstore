package com.cutepet.persistence.entity.order;

import com.cutepet.persistence.common.PaymentMethod;
import com.cutepet.persistence.common.PetType;

import javax.persistence.*;

@Embeddable
public class PetEntity {

    private String name;
    private String color;
    @Enumerated(EnumType.STRING)
    private PetType type;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    public PetEntity() {

    }

    public PetEntity(String name, String color, PetType type, PaymentMethod paymentMethod) {
        this.name = name;
        this.color = color;
        this.type = type;
        this.paymentMethod = paymentMethod;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public PetType getType() {
        return type;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
}
