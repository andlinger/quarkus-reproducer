package io.i15s.quarkus;

import io.quarkus.logging.Log;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;
import org.jboss.resteasy.reactive.server.jaxrs.RestResponseBuilderImpl;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.SocketException;

public class CommonExceptionMapper {

    @ServerExceptionMapper
    public RestResponse<MessageView> mapProcessingException(ProcessingException exception) {
        if (exception.getCause() != null && exception.getCause() instanceof SocketException) {
            return toMessageView(Response.Status.SERVICE_UNAVAILABLE, "apiUnavailable");
        }

        Log.warn("Mapping unknown ProcessingException", exception);

        if(exception.getCause() != null) {
            Log.warn("Causing exception", exception.getCause());
        }

        return toMessageView(Response.Status.INTERNAL_SERVER_ERROR, exception.getMessage());
    }

    private RestResponse<MessageView> toMessageView(Response.Status status, String message) {
        return toResponse(status, new MessageView(message));
    }

    private RestResponse<MessageView> toResponse(Response.Status status, MessageView view) {
        return RestResponseBuilderImpl.create(status, view)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
