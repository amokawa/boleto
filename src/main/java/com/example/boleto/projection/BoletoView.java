package com.example.boleto.projection;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

public interface BoletoView {
    LocalDate getExpireDate();

    String getCode();

    @Value("#{target.carPrice}")
    Float getTotal();

}
