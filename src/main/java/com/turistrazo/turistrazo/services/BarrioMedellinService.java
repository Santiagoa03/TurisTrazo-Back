package com.turistrazo.turistrazo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turistrazo.turistrazo.models.BarrioMedellin;
import com.turistrazo.turistrazo.repositories.BarrioMedellinRepository;

@Service
public class BarrioMedellinService {

    @Autowired
    private BarrioMedellinRepository barrioMedellinRepository;

    public List<BarrioMedellin> getAll() {
        return barrioMedellinRepository.findAll();
    }

}
