package com.turistrazo.turistrazo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turistrazo.turistrazo.models.Usuario;

public interface UsuarioRespository extends JpaRepository<Usuario, Integer> {

}
