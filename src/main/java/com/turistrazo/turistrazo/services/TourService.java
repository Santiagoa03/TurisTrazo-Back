package com.turistrazo.turistrazo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turistrazo.turistrazo.models.Tour;
import com.turistrazo.turistrazo.repositories.TourRepository;

import jakarta.transaction.Transactional;

@Service
public class TourService {

    @Autowired
    private TourRepository tourRepository;

    public List<Tour> getAll() {
        return tourRepository.findByValidadoTrue();
    }

    public List<Tour> getAllWithotValidado() {
        return tourRepository.findByValidadoFalse();
    }

    public Optional<Tour> findById(Integer id) {
        return tourRepository.findById(id);
    }

    @Transactional
    public void deleteById(Integer tour) {
        tourRepository.deleteById(tour);
    }

    @Transactional
    public Tour save(Tour tour) {
        return tourRepository.save(tour);
    }
}
