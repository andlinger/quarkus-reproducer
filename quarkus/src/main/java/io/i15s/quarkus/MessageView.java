package io.i15s.quarkus;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.Collection;

@RegisterForReflection
public class MessageView {

    private String[] messages;

    public MessageView(String message) {
        messages = new String[]{message};
    }

    public MessageView(String... messages) {
        this.messages = messages;
    }

    public MessageView(Collection<String> messages) {
        this.messages = messages.toArray(new String[0]);
    }

    public MessageView() {
    }

    public String[] getMessages() {
        return messages;
    }

    public void setMessages(String[] messages) {
        this.messages = messages;
    }
}

