package com.cutepet.controller.User;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @RequestMapping(value = "/{user_id}", method = RequestMethod.GET)
    public Map<String, Object> getUser(@PathVariable long user_id) {
        Map<String, Object> ret = new HashMap<>();

        return ret;
    }
}
