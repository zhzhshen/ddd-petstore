package com.cutepet.contract;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;
import com.google.common.collect.ImmutableMap;
import org.junit.Rule;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class StoreConsumerPactTest {
    @Rule
    public PactProviderRule mockProvider = new PactProviderRule("store_provider", "localhost", 8080, this);

    @Pact(consumer = "store_consumer")
    public PactFragment createFragment(PactDslWithProvider builder) {
        return builder
                .given("test state")
                .uponReceiving("get all stores list")
                .path("/stores")
                .method("GET")
                .willRespondWith()
                .headers(ImmutableMap.of("Content-Type", "application/json"))
                .status(200)
                .body("{\"data\":[{\"id\":1,\"name\":\"Doggy\"},{\"id\":2,\"name\":\"Catty\"}]}")

                .uponReceiving("get all pets in a store")
                .path("/stores/1/pets")
                .method("GET")
                .willRespondWith()
                .headers(ImmutableMap.of("Content-Type", "application/json"))
                .status(200)
                .body("{\"data\":[{\"id\":1,\"name\":\"Dog1\",\"color\":\"black\",\"type\":\"husky\"},{\"id\":2,\"name\":\"Dog2\",\"color\":\"yellow\",\"type\":\"retriever\"}]}")

                .uponReceiving("get info of a pet in a store")
                .path("/stores/1/pets/1")
                .method("GET")
                .willRespondWith()
                .headers(ImmutableMap.of("Content-Type", "application/json"))
                .status(200)
                .body("{\"data\":{\"id\":1,\"name\":\"Dog1\",\"color\":\"black\",\"type\":\"husky\"}}")
                .toFragment();
    }

    @Test
    @PactVerification
    public void storeContractTest() {
        get("/stores").then().body("data.name", hasItems("Doggy", "Catty"));

        get("/stores/1/pets").then()
                .body("data.id", hasItems(1, 2))
                .body("data.name", hasItems("Dog1", "Dog2"))
                .body("data.type", hasItems("husky", "retriever"));

        get("/stores/1/pets/1").then()
                .body("data.id", equalTo(1))
                .body("data.name", equalTo("Dog1"))
                .body("data.type", equalTo("husky"));
    }
}
