package com.turistrazo.turistrazo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    public Usuario postSave(Usuario user) {
        user.setContrasena(new BCryptPasswordEncoder().encode(user.getContrasena()));
        return usuarioRespository.save(user);
    }

    public Optional<Usuario> getUserByEmail(String correo) {
        return usuarioRespository.findOneByCorreo(correo);
    }
}