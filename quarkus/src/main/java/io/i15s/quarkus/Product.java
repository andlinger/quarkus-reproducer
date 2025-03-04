package io.i15s.quarkus;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class Product {

    @NotBlank(message = "Name must not be blank")
    private String name;
    private LocalDate produced;
    private LocalDate sold;

    @AssertTrue(message = "Produced must be before sold")
    public boolean producedBeforeSold() {
        return produced.isBefore(sold);
    }

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
}
