package io.i15s.quarkus;


import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/product")
@RequestScoped
public class ProductResource {

    @GET
    public String get() {
        return "result";
    }
}
