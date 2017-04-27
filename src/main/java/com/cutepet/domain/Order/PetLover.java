package com.cutepet.domain.Order;

import javax.persistence.Embeddable;

@Embeddable
public class PetLover {

    private String name;
    private String phoneNum;

    public PetLover() {

    }

    public PetLover(String name, String phoneNum) {
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
