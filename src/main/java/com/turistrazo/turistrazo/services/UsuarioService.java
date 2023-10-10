package com.turistrazo.turistrazo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turistrazo.turistrazo.models.Usuario;
import com.turistrazo.turistrazo.repositories.UsuarioRespository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRespository usuarioRespository;

    public Usuario getUserProfile(Integer id) {
        return usuarioRespository.findById(id).orElse(null);
    }

}
