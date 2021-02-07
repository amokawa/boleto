package com.example.boleto.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Boleto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    // Using UUID just for proof of concept
    @Column(unique = true)
    String code = UUID.randomUUID().toString();

    // Setting for every
    // new boleto to 3 days ahead
    LocalDate expireDate = LocalDate.now().plusDays(3);

    @Column(unique = true)
    Long carId;

    String carBrand;

    String carModel;

    Float carPrice;

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public Long getCarId() {
        return carId;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public Float getCarPrice() {
        return carPrice;
    }
}
