package com.talentoTech.communityNetwork.services;

import com.talentoTech.communityNetwork.entitys.Departamento;
import com.talentoTech.communityNetwork.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {
    @Autowired
    private DepartamentoRepository DepartamentoRepository;

    public Departamento crearDepartamento(Departamento departamento) {
        return DepartamentoRepository.save(departamento);
    }

    public List<Departamento> obtenerDepartamento() {
        return DepartamentoRepository.findAll();
    }

    public Optional<Departamento> obtenerDepartamentoPorId(String id) {
        return DepartamentoRepository.findById(id);
    }

    public Departamento actualizarDepartamento(Departamento departamento, String id) {
        Departamento departamentoExistente = DepartamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Departamento no encontrada"));
        departamentoExistente.getNombreDepartamento(departamento.getNombre());
        departamentoExistente.setDepartamento(departamento.getDepartamento());
        return DepartamentoRepository.save(departamentoExistente);
    }

    public void eliminarDepartamento(String id) {
        DepartamentoRepository.deleteById(id);
    }
}
