package com.example.boleto.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Boleto {
    // Using UUID just for proof of concept
    @Column(unique = true)
    private final String code = UUID.randomUUID().toString();
    // Setting for every
    // new boleto to 3 days ahead
    private final LocalDate expireDate = LocalDate.now().plusDays(3);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private Long carId;

    private String carBrand;

    private String carModel;

    private Float carPrice;

    public Long getId() {
        return id;
    }

    public Long getCarId() {
        return carId;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Float getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Float carPrice) {
        this.carPrice = carPrice;
    }
}
