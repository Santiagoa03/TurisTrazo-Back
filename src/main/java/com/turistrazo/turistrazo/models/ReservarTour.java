package com.turistrazo.turistrazo.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "reservar_tour")
@Data
public class ReservarTour {

    @Id
    private Integer id;

    @Column(name = "tour")
    private Tour tour;

    @Column(name = "turista")
    private Usuario turista;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "numero_personas")
    private Integer numeroPersonas;

}
