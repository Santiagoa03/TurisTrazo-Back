package com.turistrazo.turistrazo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import com.turistrazo.turistrazo.models.Imagen;

public interface ImagenRepository extends JpaRepository<Imagen, Integer> {

    @Query("SELECT i FROM Imagen i WHERE i.tour.id = :tourId")
    List<Imagen> findAllByTourId(@Param("tourId") Integer tourId);

    @Query("SELECT i FROM Imagen i WHERE i.sitioInteres.id = :sitioId")
    List<Imagen> findAllBySitioId(@Param("sitioId") Integer sitioId);
}
