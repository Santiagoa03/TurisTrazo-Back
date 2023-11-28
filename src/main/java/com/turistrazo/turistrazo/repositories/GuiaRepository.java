package com.turistrazo.turistrazo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.turistrazo.turistrazo.models.Guia;

public interface GuiaRepository extends JpaRepository<Guia, Integer> {

    @Query("SELECT g FROM Guia g WHERE g.usuario.numeroIdentidad = :numeroIdentidad")
    Guia findByUsuarioNumeroIdentidad(@Param("numeroIdentidad") Integer numeroIdentidad);

}
