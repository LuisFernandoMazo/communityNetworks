package com.talentoTech.communityNetwork.services;

import com.talentoTech.communityNetwork.dto.PublicacionDTO;
import com.talentoTech.communityNetwork.dto.UsuarioDTO;
import com.talentoTech.communityNetwork.entitys.Ciudad;
import com.talentoTech.communityNetwork.entitys.Publicacion;
import com.talentoTech.communityNetwork.entitys.TipoPublicacion;
import com.talentoTech.communityNetwork.entitys.Usuario;
import com.talentoTech.communityNetwork.repository.CiudadRepository;
import com.talentoTech.communityNetwork.repository.PublicacionRepository;
import com.talentoTech.communityNetwork.repository.TipoPublicacionRepository;
import com.talentoTech.communityNetwork.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Parser;
import java.rmi.ServerException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicacionService {
    @Autowired
    private PublicacionRepository publicacionRepository;

    @Autowired
    private CiudadRepository ciudadRepository;

    @Autowired
    private TipoPublicacionRepository tipoPublicacionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Publicacion createPost(
            String titulo, String descripcion, String direccion,
            LocalDate fechaInicio, LocalDate fechaFin,
            Integer idCiudad, Integer idTipoPublicacion,
            String idUsuarioPublicador, String imageUrl
    ) throws  Exception {

        Ciudad ciudad = ciudadRepository.findById(idCiudad).orElseThrow(() -> new RuntimeException("Ciudad no encontrada"));
        TipoPublicacion tipoPublicacion = tipoPublicacionRepository.findById(idTipoPublicacion).orElseThrow(() -> new RuntimeException("Tipo de publicación no encontrado"));
        Usuario usuario = usuarioRepository.findById(idUsuarioPublicador).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Publicacion publicacion = new Publicacion();
        publicacion.setTitulo(titulo);
        publicacion.setDescripcion(descripcion);
        publicacion.setDireccion(direccion);
        publicacion.setFechaInicio(fechaInicio);
        publicacion.setFechaFin(fechaFin);
        publicacion.setCiudad(ciudad);
        publicacion.setTipoPublicacion(tipoPublicacion);
        publicacion.setUsuarioPublicador(usuario);
        publicacion.setImages(imageUrl);
        publicacion.setFechaPublicacion(LocalDate.now());

        return publicacionRepository.save(publicacion);
    }

    public List<PublicacionDTO> findAllPublicaciones() {
        List<Publicacion> publicaciones = publicacionRepository.findAll();

        return publicaciones.stream().map(publicacion -> {
            UsuarioDTO usuarioDTO = new UsuarioDTO(
                    publicacion.getUsuarioPublicador().getNombre(),
                    publicacion.getUsuarioPublicador().getApellido(),
                    publicacion.getUsuarioPublicador().getCorreo(),
                    publicacion.getUsuarioPublicador().getTelefono()
            );

            return new PublicacionDTO(publicacion, usuarioDTO);
        }).collect(Collectors.toList());
    }


    public PublicacionDTO findPublicacionById(Integer id) {
        Publicacion publicacion = publicacionRepository.findById(id).orElseThrow(()-> new RuntimeException("Publicación no encontrada"));

        UsuarioDTO usuarioDTO = new UsuarioDTO(
                publicacion.getUsuarioPublicador().getNombre(),
                publicacion.getUsuarioPublicador().getApellido(),
                publicacion.getUsuarioPublicador().getCorreo(),
                publicacion.getUsuarioPublicador().getTelefono()
        );

        return new PublicacionDTO(publicacion, usuarioDTO);
    }

    public List<PublicacionDTO> filtrarPublicaciones(String query, LocalDate fecha, String ciudad, String tipo) {
        // Llamar al repositorio para obtener las publicaciones filtradas
        List<Publicacion> publicaciones = publicacionRepository.filtrarPorParametros(query, fecha, ciudad, tipo);

        // Convertir la lista de Publicacion a PublicacionDTO, incluyendo UsuarioDTO
        return publicaciones.stream().map(publicacion -> {
            // Crear el UsuarioDTO a partir del usuario publicador de la publicación
            UsuarioDTO usuarioDTO = new UsuarioDTO(
                    publicacion.getUsuarioPublicador().getNombre(),
                    publicacion.getUsuarioPublicador().getApellido(),
                    publicacion.getUsuarioPublicador().getCorreo(),
                    publicacion.getUsuarioPublicador().getTelefono()
            );

            // Retornar la PublicacionDTO
            return new PublicacionDTO(publicacion, usuarioDTO);
        }).collect(Collectors.toList());
    }
}
