package io.i15s.quarkus;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/v1/products")
@RequestScoped
public class ProductResource {

    @Inject
    ProductService service;

    @POST
    public void create() {
        service.produce();
    }
}
