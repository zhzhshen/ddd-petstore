package com.cutepet.persistence.entity.order;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "OrderTable")
public class Order {

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
    private List<PetInOrder> pets;
    @Embedded
    @AttributeOverrides( {
            @AttributeOverride(name = "name", column = @Column(name = "client_name")),
            @AttributeOverride(name = "phoneNum", column = @Column(name = "client_phone_num"))
    })
    private PetLover petLover;

    public Order() {
    }

    public Order(Date orderTime, Long userId, List<PetInOrder> pets, PetLover petLover) {
        this.orderTime = orderTime;
        this.userId = userId;
        this.pets = pets;
        this.petLover = petLover;
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

    public List<PetInOrder> getPets() {
        return pets;
    }

    public PetLover getPetLover() {
        return petLover;
    }
}
