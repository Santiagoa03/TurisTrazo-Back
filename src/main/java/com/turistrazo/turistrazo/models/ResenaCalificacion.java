package com.turistrazo.turistrazo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "resena_calificacion")
@Data
public class ResenaCalificacion {

    @Id
    private Integer id;

    @Column(name = "guia")
    private Guia guia;

    @Column(name = "barrio")
    private BarrioMedellin barrio;

    @Column(name = "descripcion")
    private String descripcion;

}
