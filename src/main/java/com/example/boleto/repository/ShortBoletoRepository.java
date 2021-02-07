package com.example.boleto.repository;

import com.example.boleto.entity.Boleto;
import com.example.boleto.projection.BoletoView;
import org.springframework.data.repository.Repository;

// Closed projection
public interface ShortBoletoRepository extends Repository<Boleto, Long> {
    BoletoView getBoletoById(Long id);
}
