package com.turistrazo.turistrazo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.turistrazo.turistrazo.models.Usuario;
import com.turistrazo.turistrazo.repositories.UsuarioRespository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRespository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = userRepo.findOneByCorreo(email)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con el email: " + email + " no existe."));

        return new UserDetailsImpl(usuario);
    }

}
