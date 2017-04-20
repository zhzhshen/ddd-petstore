package com.cutepet.controller;

import com.cutepet.domain.Store.Store;
import com.cutepet.repositories.StoreRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    StoreRepository repository;

    @RequestMapping()
    public Map<String, Object> getAllStores() {
        Map ret = new HashMap<String, Object>();

        List stores = new LinkedList();
        for (Store s : repository.findAll()) {
            stores.add(s);
        }
        ret.put("data", stores);

        return ret;
    }
}
