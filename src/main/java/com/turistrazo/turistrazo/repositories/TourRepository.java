package com.turistrazo.turistrazo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turistrazo.turistrazo.models.Tour;

public interface TourRepository extends JpaRepository<Tour, Integer> {

    List<Tour> findByValidadoTrue();

    List<Tour> findByValidadoFalse();

}
