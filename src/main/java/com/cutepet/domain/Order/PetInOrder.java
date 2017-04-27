package com.cutepet.domain.Order;

import com.cutepet.domain.Common.PaymentMethod;
import com.cutepet.domain.Common.PetType;

import javax.persistence.*;

@Embeddable
public class PetInOrder {

    private String name;
    private String color;
    @Enumerated(EnumType.STRING)
    private PetType type;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    public PetInOrder() {

    }

    public PetInOrder(String name, String color, PetType type, PaymentMethod paymentMethod) {
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
