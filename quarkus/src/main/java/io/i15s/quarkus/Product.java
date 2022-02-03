package io.i15s.quarkus;

import javax.money.MonetaryAmount;

public class Product {

    private String name;
    private MonetaryAmount price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MonetaryAmount getPrice() {
        return price;
    }

    public void setPrice(MonetaryAmount price) {
        this.price = price;
    }
}
