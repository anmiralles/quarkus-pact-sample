package org.acme.fruits;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@QuarkusTest
public class FruitResourceTests {

    @Test
    public void testFindById() {
        Fruit fruit = new Fruit();
        fruit.id= 1L;
        fruit.name = "Cherry";
        given()
            .when()
                .get("/fruits/{id}", 1L)
            .then()
                .statusCode(200)
                .body("id", equalTo(fruit.id.intValue()))
                .body("name", equalTo(fruit.name));
    }
}
