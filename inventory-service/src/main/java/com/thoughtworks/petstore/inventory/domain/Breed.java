package com.thoughtworks.petstore.inventory.domain;

import io.swagger.annotations.ApiModel;

@ApiModel("Breed Domain Entity")
public class Breed {
    private String id;
    private String name;
    private String description;
    private String image_url;

    public Breed(String name, String description, String image_url) {
        this.name = name;
        this.description = description;
        this.image_url = image_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
