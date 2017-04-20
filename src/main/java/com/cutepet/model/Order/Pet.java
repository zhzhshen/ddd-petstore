package com.cutepet.model.Order;

import com.cutepet.model.Common.PaymentMethod;

public class Pet {

    private String name;
    private String color;
    private PaymentMethod paymentMethod;

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
}
