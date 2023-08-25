package org.acme.fruits;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.CoreMatchers.equalTo;

@QuarkusTest
public class FruitResourceTests {

    @InjectMock
    FruitRepository fruitRepository;

    @Test
    public void shouldListFruits() {

        Mockito.when(this.fruitRepository.listAll()).thenReturn(TestData.getFruits());

        given()
            .when()
                 .get("/fruits")
            .then()
                .statusCode(200)
                .contentType(JSON)
                .extract()
                .body()
                .jsonPath().getList(".", Fruit.class);
    }


    @Test
    public void shouldFindFruitById() {

        Mockito.when(this.fruitRepository.findById(any(Long.class)))
                .thenReturn(TestData.getFruit());

        given()
            .when()
                .get("/fruits/1")
            .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("name", equalTo("Cherry"));
    }
}
