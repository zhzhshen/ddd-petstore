package com.cutepet.controller.Order;

import com.cutepet.domain.Common.Utils;
import com.cutepet.domain.Order.Order;
import com.cutepet.domain.Order.PetInOrder;
import com.cutepet.repositories.Order.OrderRepository;
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

        Map<String, String> orderData = (HashMap)body.get("data");
        Long userId = Long.parseLong(orderData.get("userId"));
        orderRepository.save(new Order(new Date(), userId));

        return ret;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Map<String, Object> getAllOrders() {
        Map<String, Object> ret = new HashMap<>();

        List<Map<String, Object>> orderList = new ArrayList<>();
//        orderRepository.findAll().forEach((order -> {
//            try {
//                List<PetInOrder> pets = petRepository.findByOrderId(order.getId());
//                Map<String, Object> orderMap = Utils.introspect(order);
//                orderMap.put("pets", pets);
//                orderList.add(orderMap);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }));
//        ret.put("data", orderList);

        return ret;
    }

    @RequestMapping(value = "/{order_id}", method = RequestMethod.GET)
    public Map<String, Object> getOrder(@PathVariable long order_id) {
        Map<String, Object> ret = new HashMap<>();

//        List<PetInOrder> pets = petRepository.findByOrderId(order_id);
//        Map<String, Object> orderMap = null;
//        try {
//            orderMap = Utils.introspect(orderRepository.findById(order_id).get(0));
//            orderMap.put("pets", pets);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        ret.put("data", orderMap);

        return ret;
    }
}
