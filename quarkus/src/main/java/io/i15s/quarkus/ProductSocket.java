package io.i15s.quarkus;

import io.quarkus.websockets.next.OnOpen;
import io.quarkus.websockets.next.WebSocket;
import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.RequestScoped;

import java.time.Duration;

@WebSocket(path = "/v1/products")
@RequestScoped
public class ProductSocket {

    @OnOpen
    public Multi<Product> onOpen() {
        return Multi.createFrom()
                .ticks()
                .every(Duration.ofSeconds(2))
                .map(aLong -> new Product(String.valueOf(aLong)));
    }
}
