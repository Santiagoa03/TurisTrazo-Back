package com.turistrazo.turistrazo.models;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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
@Table(name = "reserva_tour")
@Data
public class ReservarTour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "tour")
    @ManyToOne
    private Tour tour;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "numero_personas")
    private Integer numeroPersonas;

    @Column(name = "numero_contacto")
    private String numeroContacto;

    @Column(name = "precio_estimado")
    private String precioEstimado;
}