package com.cutepet.controller.Store;

import com.cutepet.util.TestUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class StoreControllerTest {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;
    @Mock
    private StoreController storeController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(storeController).build();
    }

    @Test
    public void should_able_get_all_stores() throws Exception {
        when(storeController.getAllStores()).thenReturn(ImmutableMap.of("data",
                ImmutableList.of(ImmutableMap.of("name", "Dogy"))));

        mvc.perform(get("/stores"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("$.data[0].name", is("Dogy")));
    }
}
