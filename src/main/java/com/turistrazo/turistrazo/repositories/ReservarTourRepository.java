package com.turistrazo.turistrazo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.turistrazo.turistrazo.models.ReservarTour;

public interface ReservarTourRepository extends JpaRepository<ReservarTour, Integer> {

    @Query("SELECT r FROM ReservarTour r WHERE r.tour.guia.usuario.numeroIdentidad = :guiaId")
    List<ReservarTour> findAllByGuiaId(@Param("guiaId") Integer guiaId);
}
