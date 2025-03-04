package io.i15s.quarkus;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.RequestScoped;
import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/v1/products")
@RequestScoped
public class ProductResource {

    @POST
    public void create(@Valid Product product) {
        Log.info("Created product with name " + product.getName());
    }
}
