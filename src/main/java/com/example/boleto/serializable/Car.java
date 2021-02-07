package com.example.boleto.serializable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.io.Serializable;
import java.time.LocalDate;

@JsonDeserialize(builder = Car.Builder.class)
public class Car implements Serializable {
    Long Id;
    String brand;
    String model;
    Float price;
    LocalDate createdAt;

    public Car() {
    }

    public Car(Long id, String brand, String model, Float price, LocalDate createdAt) {
        super();
        Id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Car{" +
                "Id=" + Id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", createdAt=" + createdAt +
                '}';
    }

    @JsonPOJOBuilder
    static class Builder {
        Long id;
        String brand;
        String model;
        Float price;
        LocalDate createdAt;

        Builder withId(Long id) {
            this.id = id;
            return this;
        }

        Builder withBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder withModel(String model) {
            this.model = model;
            return this;
        }

        Builder withPrice(Float price) {
            this.price = price;
            return this;
        }

        Builder withCeatedAt(LocalDate createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Car build() {
            return new Car(id, brand, model, price, createdAt);
        }
    }
}
