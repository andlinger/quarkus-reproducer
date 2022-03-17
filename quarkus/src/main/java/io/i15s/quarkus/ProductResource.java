package io.i15s.quarkus;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/product")
@RequestScoped
public class ProductResource {

    @RestClient
    HttpClient client;

    @GET
    public Product get() {
        var product = new Product();
        product.setName(client.get());

        return product;
    }
}
