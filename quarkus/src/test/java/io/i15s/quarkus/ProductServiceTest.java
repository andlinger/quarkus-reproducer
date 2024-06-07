package io.i15s.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.helpers.test.AssertSubscriber;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class ProductServiceTest {

    @Inject
    ProductService productService;

    @Test
    void working() {
        AssertSubscriber<Product> subscriber = productService.stream()
                .subscribe()
                .withSubscriber(AssertSubscriber.create());

        productService.produce();

        subscriber.awaitNextItem();

        var products = subscriber.getItems();
        Assertions.assertEquals(1, products.size());
    }

    @Test
    void notWorking() {
        AssertSubscriber<Product> subscriber = productService.stream()
                .subscribe()
                .withSubscriber(AssertSubscriber.create());

        productService.produce();

        subscriber.awaitNextItem();

        var products = subscriber.getItems();
        Assertions.assertEquals(1, products.size());

        var product = products.getFirst();
        Assertions.assertEquals("Product Test", product.name());
    }
}
