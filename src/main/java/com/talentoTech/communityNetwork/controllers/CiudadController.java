package com.talentoTech.communityNetwork.controllers;

import com.talentoTech.communityNetwork.entitys.Ciudad;
import com.talentoTech.communityNetwork.repository.CiudadRepository;
import com.talentoTech.communityNetwork.services.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/ciudad")
public class CiudadController {

    @Autowired
    private CiudadService ciudadService;

    @PostMapping("/crear")
    public ResponseEntity<Ciudad> crearCiudad(@RequestParam("nombre") String nombreCiudad,@RequestParam("idDepartamento") Integer idDepartamento) {
        if (nombreCiudad == null || idDepartamento == null) {
            return ResponseEntity.badRequest().body(null);
        }
        Ciudad nuevaCiudad = ciudadService.crearCiudad(nombreCiudad, idDepartamento);
        return ResponseEntity.ok(nuevaCiudad);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ciudad> obtenerCiudadPorId(@PathVariable Integer id){
        Ciudad ciudad = ciudadService.obtenerCiudadPorId(id).orElseThrow(() -> new RuntimeException("Departamento no encontrado"));
        return ResponseEntity.ok(ciudad);
    }
}
