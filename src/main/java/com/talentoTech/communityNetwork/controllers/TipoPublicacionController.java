package com.talentoTech.communityNetwork.controllers;

import com.talentoTech.communityNetwork.entitys.TipoPublicacion;
import com.talentoTech.communityNetwork.services.TipoPublicacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TipoPublicacionController {
    private TipoPublicacionService tipoPublicacionService;

    @PostMapping("/crearTipoPublicacion")
    public ResponseEntity<TipoPublicacion> crearTipoPublicacion(@RequestBody TipoPublicacion publicacion){

        if(publicacion.getNombreTipo() == null || publicacion.getNombreTipo().isEmpty()){
            return  ResponseEntity.badRequest().body(null);
        }
        TipoPublicacion tipoPublicacion = tipoPublicacionService.crearTipoPublicacion(publicacion);

        return ResponseEntity.ok(tipoPublicacion);
    }
}
