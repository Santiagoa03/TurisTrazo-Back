package com.turistrazo.turistrazo.services;

import java.nio.file.ProviderMismatchException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.turistrazo.turistrazo.dto.DataPasswordDTO;
import com.turistrazo.turistrazo.dto.RegisterDataDTO;
import com.turistrazo.turistrazo.models.Usuario;
import com.turistrazo.turistrazo.repositories.GuiaRepository;
import com.turistrazo.turistrazo.repositories.UsuarioRespository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRespository usuarioRespository;

    @Autowired
    private GuiaRepository guiaRepository;

    @Autowired
    private EmailSenderService emailService;

    public Usuario getUserProfile(Integer id) {
        return usuarioRespository.findById(id).orElse(null);
    }

    @Transactional
    public Usuario postSave(RegisterDataDTO register) {
        register.user.setContrasena(new BCryptPasswordEncoder().encode(register.user.getContrasena()));

        Usuario user = usuarioRespository.save(register.user);
        if (register.getGuide() != null) {
            guiaRepository.save(register.getGuide());
        }
        return user;
    }

    @Transactional
    public void resetPasswordn(String email) {

        Usuario usuario = usuarioRespository.findOneByCorreo(email)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con el email: " + email + " no existe."));
        String newPassword = String.valueOf(new Date());
        usuario.setContrasena(new BCryptPasswordEncoder().encode(newPassword));
        usuarioRespository.save(usuario);
        emailService.sendEmail(usuario.getCorreo(), "Recuperación de contraseña",
                "usuario: " + usuario.getCorreo() + " Contraseña:" + newPassword);
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

    @Transactional
    public void changePassword(DataPasswordDTO inforPassword) {

        try {
            Usuario usuario = usuarioRespository.findById(inforPassword.getId())
                    .orElseThrow(() -> new UsernameNotFoundException(
                            "El usuario con el id: " + inforPassword.getId() + " no existe."));

            if (checkPassword(inforPassword.getOldPassword(), usuario.getContrasena())) {
                usuario.setContrasena(new BCryptPasswordEncoder().encode(inforPassword.getNewPassword()));
                usuarioRespository.save(usuario);
            }
        } catch (ProviderMismatchException e) {
            throw new RuntimeException("Error: Las contraseñas no coinciden.", e);
        }

    }

    private boolean checkPassword(String rawPassword, String encodedPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean passwordsMatch = passwordEncoder.matches(rawPassword, encodedPassword);

        if (!passwordsMatch) {
            throw new ProviderMismatchException("Las contraseñas no coinciden.");
        }
        return passwordsMatch;
    }

}