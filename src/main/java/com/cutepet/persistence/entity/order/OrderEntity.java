package com.cutepet.persistence.entity.order;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "OrderTable")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "orderTime")
    @Temporal(TemporalType.TIME)
    private Date orderTime;
    @Column(name = "userId")
    private Long userId;
    @ElementCollection
    @CollectionTable(
            name = "ORDER_PETS",
            joinColumns = @JoinColumn(name = "ORDER_ID")
    )
    private List<PetEntity> pets;
    @Embedded
    @AttributeOverrides( {
            @AttributeOverride(name = "name", column = @Column(name = "client_name")),
            @AttributeOverride(name = "phoneNum", column = @Column(name = "client_phone_num"))
    })
    private CustomerEntity customer;

    public OrderEntity() {
    }

    public OrderEntity(Date orderTime, Long userId, List<PetEntity> pets, CustomerEntity customer) {
        this.orderTime = orderTime;
        this.userId = userId;
        this.pets = pets;
        this.customer = customer;
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

    public Long getUserId() {
        return userId;
    }

    public List<PetEntity> getPets() {
        return pets;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }
}
