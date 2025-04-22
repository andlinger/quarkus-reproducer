package io.i15s.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class ProductResourceTest {

    @Test
    void create() {
        var body = """
                {
                    "name": "",
                    "produced": "2025-03-10",
                    "sold": "2025-03-01",
                    "price": 1.1
                }
                """;

        RestAssured.given()
                .log()
                .all()
                .body(body)
                .contentType("application/json")
                .post("/v1/products")
                .then()
                .statusCode(400);

        body = """
                {
                    "name": "Product",
                    "produced": "2025-03-10",
                    "sold": "2025-03-01",
                    "price": 1.1
                }
                """;

        RestAssured.given()
                .log()
                .all()
                .body(body)
                .contentType("application/json")
                .post("/v1/products")
                .then()
                .statusCode(204);
    }
}
