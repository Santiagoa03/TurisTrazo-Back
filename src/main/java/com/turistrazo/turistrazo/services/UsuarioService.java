package com.turistrazo.turistrazo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turistrazo.turistrazo.models.TipoUsuario;
import com.turistrazo.turistrazo.models.Usuario;
import com.turistrazo.turistrazo.repositories.UsuarioRespository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRespository usuarioRespository;

    public Usuario getUserProfile(Integer id) {
        return usuarioRespository.findById(id).orElse(null);
    }

    public Usuario postSave() {
        Usuario prueba = new Usuario();
        TipoUsuario tipo = new TipoUsuario();
        tipo.setId(1);
        prueba.setNombre("Santiago");
        prueba.setContraseña("Hola");
        prueba.setCelular("123");
        prueba.setCorreo("123@gmaill.com");
        prueba.setTipoUsuario(tipo);
        prueba.setNumeroIdentidad(999);
        System.out.println("Prueba 2");

        return usuarioRespository.save(prueba);
    }
}
