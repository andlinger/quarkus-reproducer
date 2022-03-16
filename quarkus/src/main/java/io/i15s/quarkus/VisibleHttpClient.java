package io.i15s.quarkus;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@RegisterRestClient
@Path("/get")
public interface VisibleHttpClient {

    @GET
    String get();
}
