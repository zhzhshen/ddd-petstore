package com.cutepet.controller.Order;

import com.cutepet.domain.Order.Order;
import com.google.common.collect.ImmutableMap;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class OrderControllerTest {
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;
    @Mock
    private OrderController orderController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(orderController).build();
    }

    @Test
    public void should_able_create_an_order() throws Exception {
        List<Order> orders = new ArrayList<>();

        when(orderController.createOrder(anyObject()))
                .thenAnswer(invocationOnMock -> {
            Map<String, Object> body = (HashMap)invocationOnMock.getArguments()[0];
            Map<String, String> orderData = (HashMap)body.get("data");
            Long userId = Long.parseLong(orderData.get("userId"));
            orders.add(new Order(new Date(), userId));
            return ImmutableMap.of("data", ImmutableMap.of("status", "OK"));
        });
        when(orderController.getAllOrders()).thenAnswer(invocationOnMock -> ImmutableMap.of("data", orders));

        mvc.perform(post("/orders")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"data\":{\"userId\":\"1\"}}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data.status", is("OK")));
        mvc.perform(get("/orders"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data[0].userId", is(1)))
                .andExpect(jsonPath("$.data[0].orderTime", notNullValue()));
    }

}