package com.turistrazo.turistrazo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turistrazo.turistrazo.models.TipoUsuario;
import com.turistrazo.turistrazo.repositories.TipoUsuarioRepository;

@Service
public class TipoUsuarioService {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    public List<TipoUsuario> getAll() {
        return tipoUsuarioRepository.findAll();
    }

}
