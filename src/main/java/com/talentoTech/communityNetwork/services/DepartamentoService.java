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
    private DepartamentoRepository departamentoRepository;

    public Departamento crearDepartamento(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public List<Departamento> getAllDpto() {
        return departamentoRepository.findAll();
    }

    public Optional<Departamento> obtenerDepartamentoPorId(Integer id) {
        return departamentoRepository.findById(id);
    }

}
