package com.example.boleto.repository;

import com.example.boleto.entity.Boleto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BoletoRepository extends CrudRepository<Boleto, Long> {
    @Query(value = "SELECT code, expire_date, car_price FROM boleto WHERE id = ?1", nativeQuery = true)
    Object getShortBoleto(Long id);
}
