package com.turistrazo.turistrazo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tour")
@Data
public class Tour {

    @Id
    private Integer id;

    @JoinColumn(name = "barrio")
    @ManyToOne
    private BarrioMedellin barrioMedellin;

    @JoinColumn(name = "guia")
    @ManyToOne
    private Guia guia;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;
}
