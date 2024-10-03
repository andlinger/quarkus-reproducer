package io.i15s.quarkus;

import org.bson.types.ObjectId;

public class Product {

    private ObjectId id;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}
