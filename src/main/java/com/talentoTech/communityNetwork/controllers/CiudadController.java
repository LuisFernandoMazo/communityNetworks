package com.talentoTech.communityNetwork.controllers;

import com.talentoTech.communityNetwork.entitys.Ciudad;
import com.talentoTech.communityNetwork.repository.CiudadRepository;
import com.talentoTech.communityNetwork.services.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ciudades")
public class CiudadController {

    @Autowired
    private CiudadRepository ciudadRepository;

    @PostMapping
    public Ciudad crearCiudad(@RequestBody Ciudad ciudad) {
        return ciudadRepository.save(ciudad);
    }

    CiudadService servicio = new CiudadService();
    private ResponseEntity<Object> ReponseEntity;

    @GetMapping("/listarCiudades")
    public List<Ciudad> listar(){
        return servicio.getLista();
    }

    @GetMapping
    public List<Ciudad> obtenerCiudades() {
        return ciudadRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ciudad> obtenerCiudadPorId(@PathVariable String id){
        return ciudadRepository.findById(id)
                .map(ciudad -> ResponseEntity.ok(ciudad))
                .orElse(ReponseEntity.notFound().build());
        }
    }
