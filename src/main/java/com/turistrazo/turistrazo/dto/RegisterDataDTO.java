package com.turistrazo.turistrazo.dto;

import com.turistrazo.turistrazo.models.Guia;
import com.turistrazo.turistrazo.models.Usuario;

import lombok.Data;

@Data
public class RegisterDataDTO {
    public Usuario user;
    private Guia guide;
}