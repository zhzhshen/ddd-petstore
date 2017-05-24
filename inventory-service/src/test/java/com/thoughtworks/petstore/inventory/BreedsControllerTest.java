package com.thoughtworks.petstore.inventory;

import com.thoughtworks.petstore.inventory.controller.BreedsController;
import com.thoughtworks.petstore.inventory.controller.SpeciesController;
import com.thoughtworks.petstore.inventory.domain.Breed;
import com.thoughtworks.petstore.inventory.domain.Species;
import com.thoughtworks.petstore.inventory.repository.BreedsRepository;
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
import java.util.Optional;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BreedsControllerTest {
    final private Species species = new Species("Dog", "Mammal", "https://en.wikipedia.org/wiki/Dog#/media/File:Collage_of_Nine_Dogs.jpg");
    final String jsonContent = "[{\"name\":\"Husky\",\"description\":\"Two Ha\",\"image_url\":\"http://dogtime.com/dog-breeds/siberian-husky\"}]";
    final List<Breed> listContent = new ArrayList() {{
        add(new Breed("Husky", "Two Ha", "http://dogtime.com/dog-breeds/siberian-husky"));
    }};

    private MockMvc mvc;

    @InjectMocks BreedsController breedsController;
    @InjectMocks SpeciesController speciesController;
    @Mock BreedsRepository breedsRepository;
    @Mock SpeciesRepository speciesRepository;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        this.mvc = MockMvcBuilders.standaloneSetup(speciesController, breedsController).build();
        when(breedsRepository.ofSpecies(eq(species))).thenReturn(listContent);
    }

    @Test
    public void should_404_to_get_all_breeds_under_an_invalid_species() throws Exception {
        when(speciesRepository.ofId("1")).thenReturn(Optional.empty());
        mvc.perform(get("/species/1/breeds").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void should_success_to_get_zero_breeds_under_empty_species() throws Exception {
        when(speciesRepository.ofId("1")).thenReturn(Optional.of(mock(Species.class)));
        mvc.perform(get("/species/1/breeds").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    public void should_success_to_get_all_breeds_under_a_valid_species() throws Exception {
        when(speciesRepository.ofId("1")).thenReturn(Optional.of(species));
        mvc.perform(get("/species/1/breeds").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonContent));
    }
}
