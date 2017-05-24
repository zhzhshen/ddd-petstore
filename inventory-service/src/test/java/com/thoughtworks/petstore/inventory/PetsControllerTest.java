package com.thoughtworks.petstore.inventory;

import com.thoughtworks.petstore.inventory.controller.BreedsController;
import com.thoughtworks.petstore.inventory.controller.PetsController;
import com.thoughtworks.petstore.inventory.controller.SpeciesController;
import com.thoughtworks.petstore.inventory.domain.Breed;
import com.thoughtworks.petstore.inventory.domain.Pet;
import com.thoughtworks.petstore.inventory.domain.Species;
import com.thoughtworks.petstore.inventory.repository.BreedsRepository;
import com.thoughtworks.petstore.inventory.repository.PetsRepository;
import com.thoughtworks.petstore.inventory.repository.SpeciesRepository;
import org.assertj.core.util.Lists;
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
import java.util.Arrays;
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
public class PetsControllerTest {
    final private String[] images = {"http://dogtime.com/dog-breeds/siberian-husky"};
    final private Species species = new Species("Dog", "Mammal", "https://en.wikipedia.org/wiki/Dog#/media/File:Collage_of_Nine_Dogs.jpg");
    final private Breed breed = new Breed("Husky", "Two Ha", "http://dogtime.com/dog-breeds/siberian-husky");
    final private Pet pet = new Pet(100, 2, "Lovely husky", images);
    final String jsonContent = "[{\"price\":100,\"stock\":2,\"description\":\"Lovely husky\",\"images\":[\"http://dogtime.com/dog-breeds/siberian-husky\"]}]";
    final List<Breed> breedList = Arrays.asList(breed);
    final List<Pet> petList = Arrays.asList(pet);

    private MockMvc mvc;
    @InjectMocks SpeciesController speciesController;
    @InjectMocks BreedsController breedsController;
    @InjectMocks PetsController petsController;
    @Mock BreedsRepository breedsRepository;
    @Mock SpeciesRepository speciesRepository;
    @Mock PetsRepository petsRepository;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        this.mvc = MockMvcBuilders.standaloneSetup(speciesController, breedsController, petsController).build();
        when(speciesRepository.ofId("1")).thenReturn(Optional.of(species));
        when(breedsRepository.ofSpecies(eq(species))).thenReturn(breedList);
        when(breedsRepository.ofId("1")).thenReturn(Optional.of(breed));
        when(petsRepository.ofBreed(breed)).thenReturn(petList);
    }

    @Test
    public void should_404_to_get_all_pets_under_an_invalid_species() throws Exception {
        when(speciesRepository.ofId("1")).thenReturn(Optional.empty());
        mvc.perform(get("/species/1/breeds/1/pets").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void should_404_to_get_all_pets_under_an_invalid_breed() throws Exception {
        when(breedsRepository.ofId("1")).thenReturn(Optional.of(mock(Breed.class)));
        mvc.perform(get("/species/1/breeds/1/pets").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void should_success_to_get_zero_breeds_under_empty_breed() throws Exception {
        when(petsRepository.ofBreed(breed)).thenReturn(Lists.emptyList());
        mvc.perform(get("/species/1/breeds/1/pets").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    public void should_success_to_get_all_pets_under_a_valid_breed() throws Exception {
        mvc.perform(get("/species/1/breeds/1/pets").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonContent));
    }
}
