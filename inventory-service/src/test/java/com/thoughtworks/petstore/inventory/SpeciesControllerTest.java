package com.thoughtworks.petstore.inventory;

import com.thoughtworks.petstore.inventory.controller.SpeciesController;
import com.thoughtworks.petstore.inventory.domain.Species;
import com.thoughtworks.petstore.inventory.repository.SpeciesRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class SpeciesControllerTest {
    final String jsonContent = "[{\"name\":\"Dog\",\"description\":\"Mammal\",\"image_url\":\"https://en.wikipedia.org/wiki/Dog#/media/File:Collage_of_Nine_Dogs.jpg\"}]";
    final List<Species> listContent = new ArrayList() {{
        add(new Species("Dog", "Mammal", "https://en.wikipedia.org/wiki/Dog#/media/File:Collage_of_Nine_Dogs.jpg"));
    }};

    private MockMvc mvc;

    @InjectMocks SpeciesController controller;
    @Mock SpeciesRepository speciesRepository;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        this.mvc = MockMvcBuilders.standaloneSetup(controller).build();
        when(speciesRepository.all()).thenReturn(listContent);
    }

    @Test
    public void should_success_to_get_all_species() throws Exception {
        mvc.perform(get("/species").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonContent));
    }
}
