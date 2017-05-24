package com.thoughtworks.petstore.inventory.controller;

import com.thoughtworks.petstore.inventory.domain.Breed;
import com.thoughtworks.petstore.inventory.domain.Pet;
import com.thoughtworks.petstore.inventory.exception.NotFoundException;
import com.thoughtworks.petstore.inventory.repository.BreedsRepository;
import com.thoughtworks.petstore.inventory.repository.PetsRepository;
import com.thoughtworks.petstore.inventory.repository.SpeciesRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/species")
public class PetsController {
    @Autowired
    SpeciesRepository speciesRepository;

    @Autowired
    BreedsRepository breedsRepository;

    @Autowired
    PetsRepository petsRepository;

    @ApiOperation(value = "The API to view pet list of breed")
    @RequestMapping(value = "/{species_id}/breeds/{breed_id}/pets", method = RequestMethod.GET)
    public List<Pet> get(@ApiParam(required = true, name = "species_id") @PathVariable String species_id,
                         @ApiParam(required = true, name = "breed_id") @PathVariable String breed_id) throws NotFoundException {
        List<Breed> breeds = speciesRepository.ofId(species_id)
                .map(species -> breedsRepository.ofSpecies(species))
                .orElseThrow(() -> new NotFoundException());
        Breed breed = breedsRepository.ofId(breed_id)
                .orElseThrow(() -> new NotFoundException());

        if (breeds.contains(breed)) {
            return petsRepository.ofBreed(breed);
        } else {
            throw new NotFoundException();
        }
    }
}
