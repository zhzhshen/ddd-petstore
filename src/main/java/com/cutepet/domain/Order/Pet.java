package com.cutepet.domain.Order;

import com.cutepet.domain.Common.PaymentMethod;

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
