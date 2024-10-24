package com.talentoTech.communityNetwork.services;

import com.talentoTech.communityNetwork.entitys.Rol;
import com.talentoTech.communityNetwork.entitys.Departamento;
import com.talentoTech.communityNetwork.entitys.Usuario;
import com.talentoTech.communityNetwork.repository.RolRepository;
import com.talentoTech.communityNetwork.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.talentoTech.communityNetwork.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void registerUsuario(Usuario u) throws Exception {
        if(u.getCedula() == null || u.getCedula().isEmpty()){
            throw new Exception("La cédula es obligatoria.");
        }
        if(usuarioRepository.findByCedula(u.getCedula()).isPresent()){
            throw new Exception("La cedula ya existe");
        }
        if(u.getCorreo() == null || u.getCorreo().isEmpty()){
            throw  new Exception("El correo no puede estar vacio");
        }
        if(usuarioRepository.findByCorreo(u.getCorreo()).isPresent()){
            throw new Exception("El correo ya existe");
        }
        if(u.getApellido() == null || u.getApellido().isEmpty()){
            throw  new Exception("El apellido es obligatorio");
        }
        if(u.getContrasena() == null || u.getContrasena().isEmpty()){
            throw  new Exception("La contraseña es obligatoria");
        }

        u.setContrasena(passwordEncoder.encode(u.getContrasena()));
        u.setEstado(true);
        Rol rolPredeterminado = rolRepository.findById(1)
                .orElseThrow(() -> new Exception("Rol no encontrado"));
        u.setRol(rolPredeterminado);

        usuarioRepository.save(u);
    }


    public boolean validateUser(String correo, String contrasena) {
        Usuario usuario = usuarioRepository.findByCorreo(correo).orElse(null);

        if(usuario != null){
            return passwordEncoder.matches(contrasena, usuario.getContrasena());
        }

        return false;
    }

    public Optional<Usuario> findByIdUser(String cedula) throws Exception {
        Usuario usuario = usuarioRepository.findByCedula(cedula).orElseThrow(() -> new Exception("Cedula no encontrada"));
            return Optional.of(usuario);
    }
}
