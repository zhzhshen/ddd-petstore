package com.cutepet.model.Store;

import com.cutepet.model.Common.PaymentMethod;

import java.util.List;

public class Pet {

    private String id;
    private String name;
    private String color;
    private List<PaymentMethod> paymentMethods;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }
}
