package com.cutepet.controller.store;

import com.cutepet.domain.store.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    Store store;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Map<String, Object> getAllStores() {
        Map<String, Object> ret = new HashMap<>();

        ret.put("data", store.getAllStores());

        return ret;
    }

    @RequestMapping(value = "/{store_id}/pets", method = RequestMethod.GET)
    public Map<String, Object> getAllPetInStore(@PathVariable long store_id) {
        Map<String, Object> ret = new HashMap<>();

        ret.put("data", store.getAllPetsInStore(store.getStore(store_id)));

        return ret;
    }

    @RequestMapping(value="/{store_id}/pets/{pet_id}", method = RequestMethod.GET)
    public Map<String, Object> getAllPetInStore(@PathVariable long store_id, @PathVariable long pet_id) {
        Map<String, Object> ret = new HashMap<>();

        ret.put("data", store.getPetInStore(store.getStore(store_id), pet_id));

        return ret;
    }
}
