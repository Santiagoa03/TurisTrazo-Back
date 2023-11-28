package com.turistrazo.turistrazo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turistrazo.turistrazo.models.Guia;
import com.turistrazo.turistrazo.repositories.GuiaRepository;

@Service
public class GuiaService {

    @Autowired
    private GuiaRepository guiaRepository;

    public Guia findById(Integer numeroIdentidad) {
        return guiaRepository.findByUsuarioNumeroIdentidad(numeroIdentidad);
    }
}
