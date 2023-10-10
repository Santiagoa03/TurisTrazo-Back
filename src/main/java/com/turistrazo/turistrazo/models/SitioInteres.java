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
@Table(name = "sitio_interes")
@Data
public class SitioInteres {

    @Id
    private Integer id;

    @Column(name = "nombre_sitio")
    private String tour;

    @JoinColumn(name = "barrio_medellin", referencedColumnName = "codigo_postal", updatable = false, insertable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private BarrioMedellin barrioMedellin;

    @Column(name = "barrio_medellin")
    private Integer idBarrioMedellin;

    @Column(name = "descripcion")
    private String descripcion;

}
