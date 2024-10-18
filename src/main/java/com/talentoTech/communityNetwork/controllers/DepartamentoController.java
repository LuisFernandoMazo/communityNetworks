package com.talentoTech.communityNetwork.controllers;

import com.talentoTech.communityNetwork.entitys.Departamento;
import com.talentoTech.communityNetwork.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    // Crear un nuevo departamento
    @PostMapping
    public Departamento crearDepartamento(@RequestBody Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    // Obtener todos los departamentos
    @GetMapping
    public List<Departamento> obtenerDepartamentos() {
        return departamentoRepository.findAll();
    }

    // Obtener un departamento por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Departamento> obtenerDepartamentoPorId(@PathVariable String id) {
        return departamentoRepository.findById(id)
                .map(departamento -> ResponseEntity.ok(departamento))
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar un departamento
    @PutMapping("/{id}")
    public ResponseEntity<Departamento> actualizarDepartamento(@PathVariable String id, @RequestBody Departamento departamentoDetalles) {
        return departamentoRepository.findById(id)
                .map(departamento -> {
                    departamento.setNombre(departamentoDetalles.getNombre());
                    Departamento departamentoActualizado = departamentoRepository.save(departamento);
                    return ResponseEntity.ok(departamentoActualizado);
                }).orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un departamento
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminarDepartamento(@PathVariable String id) {
        return departamentoRepository.findById(id)
                .map(departamento -> {
                    departamentoRepository.delete(departamento);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
