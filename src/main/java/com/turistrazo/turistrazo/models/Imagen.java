package com.turistrazo.turistrazo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "imagen")
@Data
public class Imagen {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "tour")
    @ManyToOne
    private Tour tour;

    @JoinColumn(name = "sitio_turistico")
    @ManyToOne
    private SitioInteres sitioInteres;

    @Column(name = "imagen_url")
    private String imagen;

}