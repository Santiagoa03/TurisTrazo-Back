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

    @JoinColumn(name = "guia", referencedColumnName = "numero_identidad", updatable = false, insertable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario guia;

    @Column(name = "guia")
    private Integer idGuia;

    @JoinColumn(name = "barrio_guia", referencedColumnName = "codigo_postal", updatable = false, insertable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private BarrioMedellin barrioGuia;

    @Column(name = "barrio_guia")
    private Integer idBarrioGuia;

    @Column(name = "descripcion")
    private String descripcion;

}
