package com.cutepet.controller.store;

import com.cutepet.domain.store.Store;
import com.cutepet.persistence.entity.store.StoreEntity;
import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class StoreControllerTest {

    private MockMvc mvc;

    @InjectMocks
    private StoreController storeController;
    @Mock
    private Store store;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(storeController).build();
    }

    @Test
    public void should_able_get_all_stores() throws Exception {

        when(store.getAllStores()).thenReturn(
                ImmutableList.of(new StoreEntity("Doggy"), new StoreEntity("Catty")));

        mvc.perform(get("/stores"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("$.data[0].name", is("Doggy")));
    }
}
