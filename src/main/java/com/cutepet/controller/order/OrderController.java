package com.cutepet.controller.order;

import com.cutepet.domain.order.Order;
import com.cutepet.persistence.common.PaymentMethod;
import com.cutepet.persistence.common.PetType;
import com.google.common.collect.ImmutableMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Map<String, Object> createOrder(@RequestBody Map<String, Object> body) {
        Map<String, Object> ret = new HashMap<>();

        Map<String, Object> orderData = (Map) body.get("data");
        Map<String, String> customerMap = (Map) orderData.get("customer");
        Order order = Order.createOrder((Long) orderData.get("userId"),
                customerMap.get("name"), customerMap.get("phoneNum"));

        List<Map<String, String>> petValues = (List) orderData.get("pets");
        petValues.forEach((petMap) ->
                order.addPet(petMap.get("name"),
                        petMap.get("color"),
                        PetType.valueOf(petMap.get("type")),
                        PaymentMethod.valueOf(petMap.get("payment")))
        );
        order.save();

        ret.put("data", ImmutableMap.of("status", "OK"));
        return ret;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Map<String, Object> getAllOrders() {
        Map<String, Object> ret = new HashMap<>();

        ret.put("data", Order.getAllOrders());

        return ret;
    }

    @RequestMapping(value = "/{order_id}", method = RequestMethod.GET)
    public Map<String, Object> getOrder(@PathVariable long order_id) {
        Map<String, Object> ret = new HashMap<>();

        ret.put("data", Order.getOrder(order_id));

        return ret;
    }
}
