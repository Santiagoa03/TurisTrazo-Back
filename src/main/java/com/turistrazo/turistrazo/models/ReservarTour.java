package com.turistrazo.turistrazo.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "reservar_tour")
@Data
public class ReservarTour {

    @Id
    private Integer id;

    @JoinColumn(name = "tour", referencedColumnName = "id", updatable = false, insertable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Tour tour;

    @Column(name = "tour")
    private Integer idTour;

    @JoinColumn(name = "turista", referencedColumnName = "numero_identidad", updatable = false, insertable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario turista;

    @Column(name = "turista")
    private Integer idTurista;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "numero_personas")
    private Integer numeroPersonas;

}
