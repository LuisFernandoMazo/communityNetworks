package com.talentoTech.communityNetwork.controllers;

import com.talentoTech.communityNetwork.dto.PublicacionDTO;
import com.talentoTech.communityNetwork.entitys.Publicacion;
import com.talentoTech.communityNetwork.services.PublicacionService;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.ServerException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/publicacion")
public class PublicacionController {
    private static final String IMAGE_UPLOAD_DIR = "D:/uploads/images/";
    private static final Logger logger = LoggerFactory.getLogger(PublicacionController.class);
    @Autowired
    private PublicacionService publicacionService;

    @PostMapping("/crear")
    public ResponseEntity<Publicacion> crearPublicacion(
            @RequestParam("images") MultipartFile file,
            @RequestParam("titulo") String titulo,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("direccion") String direccion,
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            @RequestParam("idCiudad") Integer idCiudad,
            @RequestParam("idTipoPublicacion") Integer idTipoPublicacion,
            @RequestParam("idUsuarioPublicador") String idUsuarioPublicador
    ){
        try {
            Path imagePath = Paths.get(IMAGE_UPLOAD_DIR);
            if (!Files.exists(imagePath)) {
                Files.createDirectories(imagePath);
            }
            logger.debug("Recibiendo solicitud para crear una publicación...");

            if (file.isEmpty()) {
                throw new RuntimeException("El archivo de imagen está vacío");
            }
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path filePath = imagePath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath);
            logger.debug("Guardando archivo en: " + filePath.toString());

            String imageUrl = "uploads/images/" + fileName;

            Publicacion publicacion = publicacionService.createPost(titulo, descripcion, direccion, fechaInicio, fechaFin, idCiudad, idTipoPublicacion, idUsuarioPublicador, imageUrl);
            logger.debug("Publicación creada exitosamente");

            return ResponseEntity.ok(publicacion);


        }catch (Exception e){
            logger.error("Error al crear la publicación: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/obtenerPublicaciones")
    public ResponseEntity<List<PublicacionDTO>> getAllPublicaciones(){
        try {
            List<PublicacionDTO> publicaciones = publicacionService.findAllPublicaciones();

            return ResponseEntity.ok(publicaciones);
        } catch (ServiceException e) {
            // Retornar un error controlado al cliente con un mensaje adecuado
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping("/obtenerPublicacionPorId/{id}")
    public ResponseEntity<PublicacionDTO> getPublicacionById(@PathVariable Integer id) {
        try {
            PublicacionDTO publicacion = publicacionService.findPublicacionById(id);
            return ResponseEntity.ok(publicacion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<PublicacionDTO>> buscarPublicaciones(
            @RequestParam(required = false) String query,
            @RequestParam(required = false) String fecha,
            @RequestParam(required = false) String ciudad,
            @RequestParam(required = false) String tipo) {

        LocalDate fechaConvertida = null;

        // Convertir el valor de la fecha a LocalDate
        if (fecha != null && !fecha.isEmpty()) {
            try {
                // Convertir la cadena de fecha (yyyy-MM-dd) a LocalDate
                fechaConvertida = LocalDate.parse(fecha);
            } catch (DateTimeParseException e) {
                // Manejo de error si la conversión falla
                return ResponseEntity.badRequest().build();  // 400 Bad Request
            }
        }

        // Llamar al servicio con los filtros aplicados
        List<PublicacionDTO> publicaciones = publicacionService.filtrarPublicaciones(query, fechaConvertida, ciudad, tipo);

        return ResponseEntity.ok(publicaciones);
    }

}
