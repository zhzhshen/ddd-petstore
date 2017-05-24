package com.thoughtworks.petstore.inventory.repository;

import com.thoughtworks.petstore.inventory.domain.Species;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SpeciesRepository {
    List<Species> all();
}
