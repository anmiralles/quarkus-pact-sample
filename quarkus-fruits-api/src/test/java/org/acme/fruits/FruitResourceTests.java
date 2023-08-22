/*
package org.acme.fruits;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FruitResourceTests {

    @InjectMock
    @RestClient
    FruitService fruitService;

    @Test
    public void testFindAll() {
        given().when().get("/fruits").then().statusCode(200).body(notNullValue());
    }

    */
/*@Test
    public void testFindById() {
        Fruit fruit = new Fruit(1L, "Cherry");
        given()
            .when()
                .get("/fruits/1")
            .then()
                .statusCode(200)
                .body("id", equalTo(fruit.getId()))
                .body("name", equalTo(fruit.getName()));
    }*//*

}
*/
