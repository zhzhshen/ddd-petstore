package com.cutepet.controller.order;

import com.cutepet.domain.order.Order;
import com.cutepet.persistence.entity.order.OrderEntity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

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
    @InjectMocks
    private OrderController orderController;
    @Mock
    private Order order;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(orderController).build();
    }

    @Test
    public void should_able_create_an_order() throws Exception {
        List<OrderEntity> orders = new ArrayList<>();

        when(order.createOrder(anyObject()))
                .thenAnswer(invocationOnMock -> {
                    OrderEntity orderEntity = (OrderEntity) invocationOnMock.getArguments()[0];
                    orders.add(orderEntity);
                    return true;
                });
        when(order.getAllOrders()).thenReturn(orders);

        mvc.perform(post("/orders")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"data\":{" +
                        "\"userId\":\"1\"," +
                        "\"pets\":[{\"name\":\"Dog1\",\"color\":\"Brown\",\"type\":\"DOG_OTHER\",\"payment\":\"PAY_ON_DELIVERY\"}]," +
                        "\"customer\":{\"name\":\"John Smith\",\"phoneNum\":\"12345678\"}" +
                        "}}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data.status", is("OK")));
        mvc.perform(get("/orders"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data[0].userId", is(1)))
                .andExpect(jsonPath("$.data[0].orderTime", notNullValue()))
                .andExpect(jsonPath("$.data[0].pets[0].name", is("Dog1")))
                .andExpect(jsonPath("$.data[0].customer.name", is("John Smith")));
    }

}
