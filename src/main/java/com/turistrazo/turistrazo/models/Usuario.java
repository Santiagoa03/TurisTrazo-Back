package com.turistrazo.turistrazo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
@SecondaryTable(name = "tipo_usuario", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
public class Usuario {

    @Id
    @Column(name = "numero_identidad")
    private Integer numeroIdentidad;

    @Column(name = "nombre_completo")
    private String nombre;

    @Column(name = "correo")
    private String correo;

    @Column(name = "celular")
    private String celular;

    @Column(name = "contrasena")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String contrasena;

    @JoinColumn(name = "id_tipo_usuario")
    @ManyToOne
    private TipoUsuario tipoUsuario;

}