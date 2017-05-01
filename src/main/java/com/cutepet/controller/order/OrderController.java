package com.cutepet.controller.order;

import com.cutepet.domain.order.Order;
import com.cutepet.persistence.common.PaymentMethod;
import com.cutepet.persistence.common.PetType;
import com.cutepet.persistence.entity.order.CustomerEntity;
import com.cutepet.persistence.entity.order.OrderEntity;
import com.cutepet.persistence.entity.order.PetEntity;
import com.cutepet.utils.Utils;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private Order order;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Map<String, Object> createOrder(@RequestBody Map<String, Object> body) {
        Map<String, Object> ret = new HashMap<>();

        Map<String, Object> orderData = (Map) body.get("data");

        List<Map<String, String>> petValues = (List) orderData.get("pets");
        List<PetEntity> pets = new ArrayList<>();;
        petValues.forEach((petMap) ->
                pets.add(new PetEntity(petMap.get("name"),
                        petMap.get("color"),
                        PetType.valueOf(petMap.get("type")),
                        PaymentMethod.valueOf(petMap.get("payment"))))
        );
        Map<String, String> customerMap = (Map) orderData.get("customer");
        OrderEntity orderEntity = new OrderEntity(new Date(), (Long) orderData.get("userId"), pets,
                new CustomerEntity(customerMap.get("name"), customerMap.get("phoneNum")));
        order.createOrder(orderEntity);

        ret.put("data", ImmutableMap.of("status", "OK"));
        return ret;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Map<String, Object> getAllOrders() {
        Map<String, Object> ret = new HashMap<>();

        List<Map<String, Object>> orderList = new ArrayList<>();
        order.getAllOrders().forEach((orderEntity) -> {
            List<PetEntity> pets = orderEntity.getPets();
            Map<String, Object> orderMap = Utils.introspect(order);
            orderMap.put("pets", pets);
            orderList.add(orderMap);
        });

        ret.put("data", orderList);

        return ret;
    }

    @RequestMapping(value = "/{order_id}", method = RequestMethod.GET)
    public Map<String, Object> getOrder(@PathVariable long order_id) {
        Map<String, Object> ret = new HashMap<>();

        Map<String, Object> orderMap;
        try {
            OrderEntity orderEntity = order.getOrder(order_id);
            List<PetEntity> pets = orderEntity.getPets();
            orderMap = Utils.introspect(orderEntity);
            orderMap.put("pets", pets);
        } catch (IndexOutOfBoundsException e) {
            orderMap = new HashMap<>();
        }
        ret.put("data", orderMap);

        return ret;
    }
}
