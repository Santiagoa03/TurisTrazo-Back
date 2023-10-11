package com.turistrazo.turistrazo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "resena_calificacion")
@Data
public class ResenaCalificacion {

    @Id
    private Integer id;

    @JoinColumn(name = "guia")
    @ManyToOne
    private Usuario guia;

    @JoinColumn(name = "barrio_guia")
    @ManyToOne
    private BarrioMedellin barrioGuia;

    @Column(name = "descripcion")
    private String descripcion;

}