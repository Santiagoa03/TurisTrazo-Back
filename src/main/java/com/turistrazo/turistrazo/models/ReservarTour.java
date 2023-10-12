package com.turistrazo.turistrazo.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "reserva_tour")
@Data
public class ReservarTour {

    @Id
    private Integer id;

    @JoinColumn(name = "tour")
    @ManyToOne
    private Tour tour;

    @JoinColumn(name = "turista")
    @ManyToOne
    private Usuario turista;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "numero_personas")
    private Integer numeroPersonas;

}