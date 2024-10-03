package io.i15s.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class ProductResourceTest {

    @Test
    void get() {
        RestAssured.get("/v1/products")
                .then()
                .statusCode(200)
                .body("id", Matchers.equalTo("66fe4c9df58b4c036cc92298"));
    }
}
