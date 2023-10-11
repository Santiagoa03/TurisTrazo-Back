package com.turistrazo.turistrazo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turistrazo.turistrazo.models.Tour;

public interface TourRepository extends JpaRepository<Tour, Integer> {

}
