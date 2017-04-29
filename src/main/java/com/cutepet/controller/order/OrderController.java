package com.cutepet.controller.order;

import com.cutepet.persistence.common.PaymentMethod;
import com.cutepet.persistence.common.PetType;
import com.cutepet.persistence.common.Utils;
import com.cutepet.persistence.entity.order.Customer;
import com.cutepet.persistence.entity.order.Order;
import com.cutepet.persistence.entity.order.PetInOrder;
import com.cutepet.persistence.repositories.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Map<String, Object> createOrder(@RequestBody Map<String, Object> body) {
        Map<String, Object> ret = new HashMap<>();

        Map<String, Object> orderData = (Map)body.get("data");
        Long userId = (Long) orderData.get("userId");

        List<PetInOrder> pets = new ArrayList<>();
        List<Map<String, String> > petValues = (List) orderData.get("pets");
        petValues.forEach((petMap) ->
                pets.add(new PetInOrder(petMap.get("name"),
                        petMap.get("color"),
                        PetType.valueOf(petMap.get("type")),
                        PaymentMethod.valueOf(petMap.get("payment"))))
        );
        Map<String, String> petLoverMap = (Map) orderData.get("customer");
        Customer customer = new Customer(petLoverMap.get("name"), petLoverMap.get("phoneNum"));
        orderRepository.save(new Order(new Date(), userId, pets, customer));

        return ret;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Map<String, Object> getAllOrders() {
        Map<String, Object> ret = new HashMap<>();

        List<Map<String, Object>> orderList = new ArrayList<>();
        orderRepository.findAll().forEach((order -> {
            try {
                List<PetInOrder> pets = order.getPets();
                Map<String, Object> orderMap = Utils.introspect(order);
                orderMap.put("pets", pets);
                orderList.add(orderMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }));
        ret.put("data", orderList);

        return ret;
    }

    @RequestMapping(value = "/{order_id}", method = RequestMethod.GET)
    public Map<String, Object> getOrder(@PathVariable long order_id) {
        Map<String, Object> ret = new HashMap<>();

        Order order = orderRepository.findById(order_id).get(0);
        List<PetInOrder> pets = order.getPets();
        Map<String, Object> orderMap = null;
        try {
            orderMap = Utils.introspect(orderRepository.findById(order_id).get(0));
            orderMap.put("pets", pets);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ret.put("data", orderMap);

        return ret;
    }
}
