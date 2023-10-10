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
@Table(name = "guia")
@Data
public class Guia {

    @Id
    private Integer id;

    @Column(name = "ciudad_residencia")
    private String ciudadResidencia;

    @Column(name = "barrio_residencia")
    private String barrioResidencia;

    @JoinColumn(name = "barrio_guia", referencedColumnName = "codigo_postal", updatable = false, insertable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private BarrioMedellin barrioGuia;

    @Column(name = "barrio_guia")
    private Integer idBarrioGuia;

    @Column(name = "ingles")
    private Boolean ingles;

    @JoinColumn(name = "usuario", referencedColumnName = "numero_identidad", updatable = false, insertable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @Column(name = "usuario")
    private Integer idUsuario;

}
