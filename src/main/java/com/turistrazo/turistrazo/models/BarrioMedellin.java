package com.turistrazo.turistrazo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "barrio_medellin")
@Data
public class BarrioMedellin {

    @Id
    @Column(name = "codigo_postal")
    private Integer codigoPostal;

    @Column(name = "nombre_barrio")
    private String nombre;

}
