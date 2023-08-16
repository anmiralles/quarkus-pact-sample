package org.acme.fruits;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusIntegrationTest;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.junit.jupiter.api.Test;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusIntegrationTest
public class FruitResourceIT {

    @TestHTTPEndpoint(FruitResource.class)
    @TestHTTPResource
    URL url;

    @Test
    public void findById() {
        FruitService service = RestClientBuilder.newBuilder()
                .baseUrl(url)
                .build(FruitService.class);
        Fruit fruit = service.findById(1L);
        assertNotNull(fruit.id);
    }
}
