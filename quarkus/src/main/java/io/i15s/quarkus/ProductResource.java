package io.i15s.quarkus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.javamoney.moneta.Money;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.PageAttributes;

@Path("/product")
@RequestScoped
public class ProductResource {

    @Inject
    ObjectMapper mapper;

    @GET
    public Product get() {
        var product = new Product();
        product.setName("Quarkus T-Shirt");
        product.setPrice(Money.of(12, "EUR"));

        return product;
    }

    @GET
    @Path("/mapper")
    @Produces(MediaType.APPLICATION_JSON)
    public String mapper() throws JsonProcessingException {
        var product = new Product();
        product.setName("Quarkus T-Shirt");
        product.setPrice(Money.of(12, "EUR"));

        return mapper.writeValueAsString(product);
    }
}
