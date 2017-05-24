package com.thoughtworks.petstore.inventory.repository;

import com.thoughtworks.petstore.inventory.domain.Species;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SpeciesRepository {
    List<Species> all();

    Optional<Species> ofId(String id);
}
