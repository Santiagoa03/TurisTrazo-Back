package com.turistrazo.turistrazo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turistrazo.turistrazo.models.SitioInteres;
import com.turistrazo.turistrazo.repositories.SitioInteresRepository;

@Service
public class SitioInteresService {

    @Autowired
    private SitioInteresRepository sitioInteresRepository;

    public List<SitioInteres> getAll() {
        return sitioInteresRepository.findAll();
    }

    public Optional<SitioInteres> findById(Integer id) {
        return sitioInteresRepository.findById(id);
    }
}
