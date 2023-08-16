package org.acme.fruits;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.PactSpecVersion;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
@ExtendWith(PactConsumerTestExt.class)
class FruitServiceContractTest {

    @Pact(provider = "quarkus-fruits-data", consumer = "quarkus-fruits-api")
    public RequestResponsePact callFindById(PactDslWithProvider builder) {
        return builder.given("findById")
                .uponReceiving("findById")
                .path("/fruits/1")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body("{ \"id\": 1, \"name\": \"Cherry\" }\n")
                .toPact();
    }

    @Test
    @PactTestFor(providerName = "quarkus-fruits-data", pactVersion = PactSpecVersion.V3)
    public void verifyFindByIdPact(MockServer mockServer) {
        System.out.println(mockServer.getUrl());
        FruitService client = RestClientBuilder.newBuilder()
                .baseUri(URI.create(mockServer.getUrl()))
                .build(FruitService.class);
        Fruit fruit = client.findById(1L);
        System.out.println(fruit);
        assertNotNull(fruit);
        assertNotNull(fruit.id);
    }

}