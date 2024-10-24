package com.talentoTech.communityNetwork.controllers;

import com.talentoTech.communityNetwork.entitys.TipoPublicacion;
import com.talentoTech.communityNetwork.services.TipoPublicacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TipoPublicacionController {
    private TipoPublicacionService tipoPublicacionService;

    @PostMapping("/crearPublicacion")
    public ResponseEntity<TipoPublicacion> crearTipoPublicacion(@RequestBody TipoPublicacion publicacion){
        TipoPublicacion tipoPublicacion = tipoPublicacionService.crearTipoPublicacion(publicacion);

        return ResponseEntity.ok(tipoPublicacion);
    }
}