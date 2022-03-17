package io.i15s.quarkus;

import javax.ws.rs.core.Response;

public class ClientException extends RuntimeException {

    private final Response.Status status;
    private final MessageView messageView;

    public ClientException(Response.Status status) {
        this.status = status;
        this.messageView = null;
    }

    public ClientException(Response.Status status, MessageView messageView) {
        this.status = status;
        this.messageView = messageView;
    }

    public Response.Status getStatus() {
        return status;
    }

    public MessageView getMessageView() {
        return messageView;
    }
}
