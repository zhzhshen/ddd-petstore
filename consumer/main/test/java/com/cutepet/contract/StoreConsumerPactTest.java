package com.cutepet.contract;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;
import com.google.common.collect.ImmutableMap;
import org.junit.Rule;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

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
                .body(new PactDslJsonBody()
                        .eachLike("data")
                            .integerType("id", 1)
                            .stringType("name", "Doggy")
                            .closeObject()
                        .closeArray())

                .uponReceiving("get all pets in a store")
                .path("/stores/1/pets")
                .method("GET")
                .willRespondWith()
                .headers(ImmutableMap.of("Content-Type", "application/json"))
                .status(200)
                .body(new PactDslJsonBody()
                        .eachLike("data")
                            .integerType("id", 1)
                            .stringType("name", "Dog1")
                            .stringType("color", "black")
                            .stringType("type", "husky")
                            .closeObject()
                        .closeArray())

                .uponReceiving("get info of a pet in a store")
                .path("/stores/1/pets/1")
                .method("GET")
                .willRespondWith()
                .headers(ImmutableMap.of("Content-Type", "application/json"))
                .status(200)
                .body(new PactDslJsonBody()
                        .object("data")
                        .integerType("id", 1)
                        .stringType("name", "Dog1")
                        .stringType("color", "black")
                        .stringType("type", "husky")
                        .closeObject())
                .toFragment();
    }

    @Test
    @PactVerification
    public void storeContractTest() {
        get("/stores").then().body("data.name", hasItem("Doggy"));

        get("/stores/1/pets").then()
                .body("data.id", hasItem(1))
                .body("data.name", hasItem("Dog1"))
                .body("data.type", hasItem("husky"));

        get("/stores/1/pets/1").then()
                .body("data.id", equalTo(1))
                .body("data.name", equalTo("Dog1"))
                .body("data.type", equalTo("husky"));
    }
}
