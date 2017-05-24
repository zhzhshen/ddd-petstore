package com.thoughtworks.petstore.inventory.domain;

import io.swagger.annotations.ApiModel;

@ApiModel("Pet Domain Entity")
public class Pet {
    private String id;
    private Number price;
    private Number stock;
    private String description;
    private String[] images;

    public Pet(Number price, Number stock, String description, String[] images) {
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.images = images;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {
        this.price = price;
    }

    public Number getStock() {
        return stock;
    }

    public void setStock(Number stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }
}
