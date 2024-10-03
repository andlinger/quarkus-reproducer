package io.i15s.quarkus;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.bson.types.ObjectId;

@Path("/v1/products")
@RequestScoped
public class ProductResource {

    @GET
    public Product get() {
        var product = new Product();
        product.setId(new ObjectId("66fe4c9df58b4c036cc92298"));
        return product;
    }
}
