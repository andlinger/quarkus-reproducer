package io.i15s.quarkus;

import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import java.util.UUID;

@ApplicationScoped
public class ProductService {

    @Channel("products-out")
    Emitter<Product> emitter;

    @Channel("products-in")
    Multi<Product> products;

    public Multi<Product> stream() {
        return products;
    }

    public void produce() {
        emitter.send(new Product(UUID.randomUUID().toString(), "Product Test"));
    }
}
