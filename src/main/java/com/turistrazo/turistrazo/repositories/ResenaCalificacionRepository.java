package com.turistrazo.turistrazo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.turistrazo.turistrazo.models.ResenaCalificacion;

public interface ResenaCalificacionRepository extends JpaRepository<ResenaCalificacion, Integer> {

    @Query("SELECT r FROM ResenaCalificacion r WHERE r.tour.id = :tourId")
    List<ResenaCalificacion> findAllByTourId(@Param("tourId") Integer tourId);
}
