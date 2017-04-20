package com.cutepet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @RequestMapping()
    public Map<String, Object> getAllStores() {
        Map ret = new HashMap<String, Object>();

        List stores = new LinkedList();
        ret.put("data", stores);
        return ret;
    }
}
