package com.turistrazo.turistrazo.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.turistrazo.turistrazo.dto.RegisterDataDTO;
import com.turistrazo.turistrazo.models.Usuario;
import com.turistrazo.turistrazo.repositories.GuiaRepository;
import com.turistrazo.turistrazo.repositories.UsuarioRespository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRespository usuarioRespository;

    @Autowired
    private GuiaRepository guiaRepository;

    public Usuario getUserProfile(Integer id) {
        return usuarioRespository.findById(id).orElse(null);
    }

    public Usuario postSave(RegisterDataDTO register) {
        register.user.setContrasena(new BCryptPasswordEncoder().encode(register.user.getContrasena()));

        Usuario user = usuarioRespository.save(register.user);
        if (register.getGuide() != null) {
            guiaRepository.save(register.getGuide());
        }
        return user;
    }

    public Optional<Usuario> getUserByEmail(String email) {
        return usuarioRespository.findOneByCorreo(email);
    }

    public ResponseEntity<Map<String, Boolean>> verifyEmail(String email) {
        Optional<Usuario> userExist = usuarioRespository.findOneByCorreo(email);
        Map<String, Boolean> response = new HashMap<>();
        response.put("existe", userExist.isPresent());
        return ResponseEntity.ok(response);
    }
}