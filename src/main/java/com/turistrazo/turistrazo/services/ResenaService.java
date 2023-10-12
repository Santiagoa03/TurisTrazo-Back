package com.turistrazo.turistrazo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turistrazo.turistrazo.models.ResenaCalificacion;
import com.turistrazo.turistrazo.repositories.ResenaCalificacionRepository;

@Service
public class ResenaService {

    @Autowired
    private ResenaCalificacionRepository resenaCalificacionRepository;

    public List<ResenaCalificacion> getAllResenas() {
        return resenaCalificacionRepository.findAll();
    }

    public void saveResena(ResenaCalificacion resenaNew) {
        resenaCalificacionRepository.save(resenaNew);
    }
}
