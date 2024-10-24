package com.talentoTech.communityNetwork.security;

import com.talentoTech.communityNetwork.entitys.Usuario;
import com.talentoTech.communityNetwork.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException{
        Optional<Usuario> usuario = usuarioRepository.findByCorreo(correo);

        usuario.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        return  new CustomUserDetails(usuario.get());
    }
}
