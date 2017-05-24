package com.thoughtworks.petstore.inventory.controller;

import com.thoughtworks.petstore.inventory.domain.Species;
import com.thoughtworks.petstore.inventory.repository.SpeciesRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/species")
public class SpeciesController {
    @Autowired
    SpeciesRepository repository;

    @ApiOperation(value = "The API to view species")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Species> all() {
        return repository.all();
    }
}
