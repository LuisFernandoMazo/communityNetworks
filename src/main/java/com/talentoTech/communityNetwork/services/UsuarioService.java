package com.talentoTech.communityNetwork.services;

import com.talentoTech.communityNetwork.dto.PublicacionByUserDTO;
import com.talentoTech.communityNetwork.dto.PublicacionDTO;
import com.talentoTech.communityNetwork.dto.UsuarioDTO;
import com.talentoTech.communityNetwork.entitys.Publicacion;
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
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public UsuarioDTO findByIdUser(String cedula) throws Exception {
        Usuario usuario = usuarioRepository.findById(cedula).orElseThrow(() -> new Exception("Cedula no encontrada"));

        List<PublicacionByUserDTO> publicacionesDTO = usuario.getPublicaciones().stream().map(publicacion -> new PublicacionByUserDTO(
                publicacion.getIdPublicacion(),
                publicacion.getTipoPublicacion(),  // Incluye tipo de publicacion
                publicacion.getCiudad(),
                publicacion.getDireccion(),
                publicacion.getTitulo(),
                publicacion.getDescripcion(),
                publicacion.getFechaPublicacion(),
                publicacion.getFechaInicio(),
                publicacion.getFechaFin(),
                publicacion.getImages()
        )).toList();

        UsuarioDTO usuarioDTO = new UsuarioDTO(
               usuario.getNombre(),
                usuario.getApellido(),
                usuario.getCorreo(),
                usuario.getTelefono(),
                publicacionesDTO
        );

        return usuarioDTO;
    }

    public Usuario findByCorreoUser(String correo) throws Exception {
        Usuario usuario = usuarioRepository.findByCorreo(correo).orElseThrow(() -> new Exception("Cedula no encontrada"));
        return  usuario;
    }
}
