package com.cutepet.persistence.entity.store;

import com.cutepet.persistence.common.PaymentMethod;
import com.cutepet.persistence.common.PetType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PetEntity")
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String color;
    @Enumerated(EnumType.STRING)
    private PetType type;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "PAYMENT_METHOD",
            joinColumns = @JoinColumn(name = "PET_ID")
    )
    private List<PaymentMethod> paymentMethods;
    private Long storeId;

    public PetEntity() {
    }

    public PetEntity(String name, String color, PetType type, List<PaymentMethod> paymentMethods, Long storeId) {
        this.name = name;
        this.color = color;
        this.type = type;
        this.paymentMethods = paymentMethods;
        this.storeId = storeId;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PetType getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public Long getStoreId() {
        return storeId;
    }
}
