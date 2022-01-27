package io.i15s.quarkus;

import io.quarkus.logging.Log;

import javax.enterprise.context.RequestScoped;
import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.Path;
import java.io.IOException;
import java.net.URI;
import java.util.Locale;

@Path("/websocket")
@RequestScoped
public class WebsocketResource {

    @GET
    public String echo1() {
        try {
            var session = ContainerProvider.getWebSocketContainer()
                    .connectToServer(EmptyEndpoint.class, URI.create("ws://localhost:9222/devtools/page/7C2C1DE8A9496C9E0872DC5DED097BEC"));
            session.getBasicRemote()
                    .sendText("test");
            return "Success";
        } catch (Exception e) {
            Log.error("Failed to connect to websocket server.", e);
            throw new InternalServerErrorException(e);
        }
    }

    @ClientEndpoint
    public static class EmptyEndpoint {
    }
}
