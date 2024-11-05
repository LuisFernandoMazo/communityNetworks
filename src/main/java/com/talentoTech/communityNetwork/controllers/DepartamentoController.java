package com.talentoTech.communityNetwork.controllers;

import com.talentoTech.communityNetwork.entitys.Departamento;
import com.talentoTech.communityNetwork.repository.DepartamentoRepository;
import com.talentoTech.communityNetwork.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    // Crear un nuevo departamento
    @PostMapping("/crear")
    public ResponseEntity<Departamento> crearDepartamento(@RequestBody Departamento departamento) {
        if (departamento.getNombreDepartamento() == null || departamento.getNombreDepartamento().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        Departamento nuevoDepartamento = departamentoService.crearDepartamento(departamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDepartamento);
    }

    // Obtener todos los departamentos
    @GetMapping("/findAllDpto")
    public List<Departamento> obtenerDepartamentos() {
        return departamentoService.getAllDpto();
    }

    // Obtener un departamento por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Departamento> obtenerDepartamentoPorId(@PathVariable Integer id) {
        Departamento dpto = departamentoService.obtenerDepartamentoPorId(id).orElseThrow(()-> new RuntimeException("Departamento no encontrado"));
        return ResponseEntity.ok(dpto);

    }/*

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
    }*/
}
