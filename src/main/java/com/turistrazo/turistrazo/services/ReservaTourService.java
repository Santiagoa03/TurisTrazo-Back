package com.turistrazo.turistrazo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turistrazo.turistrazo.models.ReservarTour;
import com.turistrazo.turistrazo.repositories.ReservarTourRepository;

import jakarta.transaction.Transactional;

@Service
public class ReservaTourService {

    @Autowired
    private ReservarTourRepository reservaTourRepository;

    @Transactional
    public void postSave(ReservarTour reserva) {
        reservaTourRepository.save(reserva);
    }

    public List<ReservarTour> findReservaByIdGuia(Integer idGuiaInteger) {
        return reservaTourRepository.findAllByGuiaId(idGuiaInteger);
    }

    @Transactional
    public void deleteById(Integer id) {
        reservaTourRepository.deleteById(id);
    }
}