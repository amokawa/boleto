package com.example.boleto.controller;

import com.example.boleto.entity.Boleto;
import com.example.boleto.projection.BoletoView;
import com.example.boleto.repository.BoletoRepository;
import com.example.boleto.repository.ShortBoletoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BoletoController {

    BoletoRepository repository;

    @Autowired
    ShortBoletoRepository shortBoletoRepository;

    public BoletoController(BoletoRepository repository) {
        this.repository = repository;
    }

    @PostMapping(value = "boleto", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public BoletoView create(@Valid @RequestBody Boleto aBoleto) {
        Boleto boleto = repository.save(aBoleto);
        return shortBoletoRepository.getBoletoById(boleto.getId());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String field = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(field, message);
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public String handleException(HttpMessageNotReadableException ex) {
        return ex.getLocalizedMessage();
    }
}
