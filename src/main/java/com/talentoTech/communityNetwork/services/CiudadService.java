package com.talentoTech.communityNetwork.services;

import com.talentoTech.communityNetwork.entitys.Ciudad;
import com.talentoTech.communityNetwork.entitys.Departamento;
import com.talentoTech.communityNetwork.repository.CiudadRepository;
import com.talentoTech.communityNetwork.repository.DepartamentoRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CiudadService {
    @Autowired
    private CiudadRepository ciudadRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public Ciudad crearCiudad(String nombreCiudad, Integer idDepartamento) {

        Departamento departamento = departamentoRepository.findById(idDepartamento)
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado"));

        Ciudad ciudad = new Ciudad(nombreCiudad, departamento);

        return  ciudadRepository.save(ciudad);
    }

    public List<Ciudad> obtenerCiudades() {
        return ciudadRepository.findAll();
    }

    public Optional<Ciudad> obtenerCiudadPorId(Integer id) {
        return ciudadRepository.findById(id);
    }
/*
    public List<Ciudad> getLista() {
        return ciudadRepository.findAll();
    }*/
}
