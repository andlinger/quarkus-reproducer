package io.i15s.quarkus;

import io.quarkus.logging.Log;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class ClientExceptionMapper implements ResponseExceptionMapper<ClientException> {

    @Override
    public ClientException toThrowable(Response response) {
        if (response != null) {
            MessageView messageView = null;

            try {
                messageView = response.readEntity(MessageView.class);
            } catch (Exception e) {
                Log.warn("Failed to read error from client.", e);
            }

            var status = Response.Status.INTERNAL_SERVER_ERROR;

            if (response.getStatusInfo() != null) {
                status = response.getStatusInfo().toEnum();
            }

            return new ClientException(status, messageView);
        }

        return new ClientException(Response.Status.INTERNAL_SERVER_ERROR);
    }

    @Override
    public boolean handles(int status, MultivaluedMap<String, Object> headers) {
        return status < 200 || status > 299;
    }
}
