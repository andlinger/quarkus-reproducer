package io.i15s.quarkus;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class Product {

    @NotBlank(message = "Name must not be blank")
    private String name;
    private Float price;
    private LocalDate produced;
    private LocalDate sold;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getProduced() {
        return produced;
    }

    public void setProduced(LocalDate produced) {
        this.produced = produced;
    }

    public LocalDate getSold() {
        return sold;
    }

    public void setSold(LocalDate sold) {
        this.sold = sold;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
