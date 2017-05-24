package com.thoughtworks.petstore.inventory;

import com.thoughtworks.petstore.inventory.controller.DemoController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ApplicationTests {
	private MockMvc mvc;

	@Before
	public void before() {
		this.mvc = MockMvcBuilders.standaloneSetup(new DemoController()).build();
	}

	@Test
	public void contextLoads() throws Exception {
		RequestBuilder requestBuilder = get("/api/hello/test");
		mvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().string("Hello! test"));
	}

}
