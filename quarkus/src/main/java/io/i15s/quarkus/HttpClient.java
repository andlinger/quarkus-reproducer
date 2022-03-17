package io.i15s.quarkus;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@RegisterRestClient
public interface HttpClient {

    @GET
    @Path("/get")
    String get();
}
