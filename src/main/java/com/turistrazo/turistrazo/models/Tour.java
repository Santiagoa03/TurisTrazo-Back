package com.turistrazo.turistrazo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tour")
@Data
public class Tour {

    @Id
    private Integer id;

    @Column(name = "barrio")
    private BarrioMedellin barrio;

    @Column(name = "guia")
    private Guia guia;

    @Column(name = "descripcion")
    private String nombre;

}
