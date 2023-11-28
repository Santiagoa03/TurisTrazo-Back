package com.turistrazo.turistrazo.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turistrazo.turistrazo.dto.DataPasswordDTO;
import com.turistrazo.turistrazo.dto.RegisterDataDTO;
import com.turistrazo.turistrazo.models.TipoUsuario;
import com.turistrazo.turistrazo.models.Usuario;
import com.turistrazo.turistrazo.services.TipoUsuarioService;
import com.turistrazo.turistrazo.services.UsuarioService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/users")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    @PostMapping("/register")
    public Usuario postSave(@RequestBody RegisterDataDTO registerData) {
        return usuarioService.postSave(registerData);
    }

    @PostMapping("/reset")
    public ResponseEntity<?> resetPassword(@RequestBody String email) {
        usuarioService.resetPasswordn(email);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public Usuario getUserProfile(@PathVariable Integer userId) {
        return usuarioService.getUserProfile(userId);
    }

    @GetMapping("/email/{email}")
    public Optional<Usuario> getUserProfile(@PathVariable String email) {
        return usuarioService.getUserByEmail(email);
    }

    @GetMapping("/verify/{email}")
    public ResponseEntity<Map<String, Boolean>> verifyEmail(@PathVariable String email) {
        return usuarioService.verifyEmail(email);
    }

    @GetMapping("/user-type")
    public List<TipoUsuario> getAllUserType() {
        return tipoUsuarioService.getAll();
    }

    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody DataPasswordDTO dataPassword) {
        this.usuarioService.changePassword(dataPassword);
        return ResponseEntity.ok().build();
    }
}
