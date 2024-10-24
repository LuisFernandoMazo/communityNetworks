package com.talentoTech.communityNetwork.security;

import com.talentoTech.communityNetwork.entitys.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CustomUserDetails implements UserDetails {
    private Usuario usuario;

    public CustomUserDetails(Usuario usuario){
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(usuario.getRol().getNombreRol()));
    }

    @Override
    public String getPassword() {
        return usuario.getContrasena();
    }

    @Override
    public String getUsername() {
        return usuario.getCorreo();
    }

    @Override
    public boolean isAccountNonExpired() {
        // Indica si la cuenta ha expirado (en este caso, no)
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Indica si la cuenta está bloqueada (en este caso, no)
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Indica si las credenciales han expirado (en este caso, no)
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Indica si la cuenta está habilitada (basado en el estado del usuario)
        return usuario.getEstado();
    }
}
