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
@Table(name = "tour")
@Data
public class Tour {

    @Id
    private Integer id;

    @JoinColumn(name = "barrio", referencedColumnName = "codigo_postal", updatable = false, insertable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private BarrioMedellin barrioMedellin;

    @Column(name = "barrio")
    private Integer idBarrio;

    @JoinColumn(name = "guia", referencedColumnName = "numero_identidad", updatable = false, insertable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario guia;

    @Column(name = "guia")
    private Integer idGuia;

    @Column(name = "descripcion")
    private String descripcion;
}
