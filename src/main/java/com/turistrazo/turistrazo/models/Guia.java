package com.turistrazo.turistrazo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "guia")
@Data
public class Guia {

    @Id
    private Integer id;

    @Column(name = "ciudad_residencia")
    private String ciudadResidencia;

    @Column(name = "barrio_residencia")
    private String barrioResidencia;

    @Column(name = "barrio_guia")
    private BarrioMedellin barrioGuia;

    @Column(name = "ingles")
    private Boolean ingles;

    @Column(name = "usuario")
    private Usuario usuario;

}
