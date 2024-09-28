package com.ecom.orderservice;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.shaded.org.checkerframework.checker.i18n.qual.LocalizableKey;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderServiceApplicationTests {
    @ServiceConnection
    static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.3.0");

    @LocalizableKey
    int port;

    @BeforeEach
    void setup(){
        RestAssured.baseURI="http://localhost";
        RestAssured.port = port;
    }

    static {
        mySQLContainer.start();
    }
    @Test
    void submitOrder() {
        String req = """
                 {
                        "skuNumber": "PROD007",
                        "qty": 102,
                        "price": 15.75
                    }
                """;
        var resp = RestAssured.given().contentType("application/json").body(req).when().post("api/orders")
                .then()
                .log().all()
                .statusCode(2012).body("qty", Matchers.notNullValue());

    }

}
