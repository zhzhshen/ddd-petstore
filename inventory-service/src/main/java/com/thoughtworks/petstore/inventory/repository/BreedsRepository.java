package com.thoughtworks.petstore.inventory.repository;

import com.thoughtworks.petstore.inventory.domain.Breed;
import com.thoughtworks.petstore.inventory.domain.Species;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BreedsRepository {

    Optional<Breed> ofId(String id);

    List<Breed> ofSpecies(Species species);
}
