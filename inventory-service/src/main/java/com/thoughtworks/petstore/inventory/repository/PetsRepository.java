package com.thoughtworks.petstore.inventory.repository;

import com.thoughtworks.petstore.inventory.domain.Breed;
import com.thoughtworks.petstore.inventory.domain.Pet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PetsRepository {
    List<Pet> ofBreed(Breed breed);
}
