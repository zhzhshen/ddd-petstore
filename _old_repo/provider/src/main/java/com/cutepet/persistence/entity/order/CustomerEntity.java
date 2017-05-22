package com.cutepet.persistence.entity.order;

import javax.persistence.Embeddable;

@Embeddable
public class CustomerEntity {

    private String name;
    private String phoneNum;

    public CustomerEntity() {

    }

    public CustomerEntity(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }
}
