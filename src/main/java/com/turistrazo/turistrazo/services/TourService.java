package com.turistrazo.turistrazo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turistrazo.turistrazo.models.Tour;
import com.turistrazo.turistrazo.repositories.TourRepository;

@Service
public class TourService {

    @Autowired
    private TourRepository tourRepository;

    public List<Tour> getAll() {
        return tourRepository.findAll();
    }

}
