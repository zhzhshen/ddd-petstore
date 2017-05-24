package com.thoughtworks.petstore.inventory.controller;

import com.thoughtworks.petstore.inventory.domain.Breed;
import com.thoughtworks.petstore.inventory.exception.NotFoundException;
import com.thoughtworks.petstore.inventory.repository.BreedsRepository;
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
public class BreedsController {
    @Autowired
    SpeciesRepository speciesRepository;

    @Autowired
    BreedsRepository breedsRepository;

    @ApiOperation(value="The API to view breed list of species")
    @RequestMapping(value = "/{id}/breeds", method = RequestMethod.GET)
    public List<Breed> get(@ApiParam(required=true, name="id") @PathVariable String id) throws NotFoundException {
        return speciesRepository.ofId(id)
                .map(species -> breedsRepository.ofSpecies(species))
                .orElseThrow(() -> new NotFoundException());
    }
}
