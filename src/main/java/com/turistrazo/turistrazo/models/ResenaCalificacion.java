package com.turistrazo.turistrazo.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "resena_calificacion")
@Data
public class ResenaCalificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resena_id_seq")
    @SequenceGenerator(name = "resena_seq", sequenceName = "resena_id_seq", allocationSize = 1)
    private Integer id;

    @JoinColumn(name = "tour")
    @ManyToOne
    private Tour tour;

    @JoinColumn(name = "turista")
    @ManyToOne
    private Usuario turista;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "calificacion_estrella")
    private Integer estrella;
}