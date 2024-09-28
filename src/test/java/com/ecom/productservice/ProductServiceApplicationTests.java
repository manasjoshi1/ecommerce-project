package com.ecom.productservice;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)    //To run on random port and not on 8080
class ProductServiceApplicationTests {

    @ServiceConnection
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");

    @LocalServerPort
    private int port;


    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    static {
        mongoDBContainer.start();
    }

    @Test
    void shouldCreateProduct() {

        String requestBody = """
                {
                    "name":"iPhone16",
                    "description":"iPhone16 is a smartphone",
                    "price":10000
                }
                """;

        RestAssured.given()
                .body(requestBody)
                .contentType("application/json")
                .when()
                .post("api/product")
                .then()
                .statusCode(201)
                .body("name", Matchers.equalTo("iPhone16"))
                .body("description", Matchers.equalTo("iPhone16 is a smartphone"));


    }

}
