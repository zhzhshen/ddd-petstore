package com.cutepet.controller.User;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {


    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public Map<String, Object> cleanUpCart() {
        Map<String, Object> ret = new HashMap<>();

        return ret;
    }

    @RequestMapping(value = "/pets", method = RequestMethod.GET)
    public Map<String, Object> getAllPets() {
        Map<String, Object> ret = new HashMap<>();

        return ret;
    }

    @RequestMapping(value = "/pets", method = RequestMethod.POST)
    public Map<String, Object> addPet() {
        Map<String, Object> ret = new HashMap<>();

        return ret;
    }

    @RequestMapping(value = "/pets/{pet_id}", method = RequestMethod.DELETE)
    public Map<String, Object> removePet(@PathVariable long pet_id) {
        Map<String, Object> ret = new HashMap<>();

        return ret;
    }

}
