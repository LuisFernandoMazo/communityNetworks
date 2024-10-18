package com.talentoTech.communityNetwork.services;

import com.talentoTech.communityNetwork.entitys.Ciudad;
import com.talentoTech.communityNetwork.repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CiudadService {
    @Autowired
    private CiudadRepository ciudadRepository;

    public Ciudad crearCiudad(Ciudad ciudad) {
        return ciudadRepository.save(ciudad);
    }

    public List<Ciudad> obtenerCiudades() {
        return ciudadRepository.findAll();
    }

    public Optional<Ciudad> obtenerCiudadPorId(String id) {
        return ciudadRepository.findById(id);
    }

    public Ciudad actualizarCiudad(Ciudad ciudad, String id) {
        Ciudad ciudadExistente = ciudadRepository.findById(id).orElseThrow(() -> new RuntimeException("Ciudad no encontrada"));
        ciudadExistente.getNombreCiudad(ciudad.getNombre());
        ciudadExistente.setDepartamento(ciudad.getDepartamento());
        return ciudadRepository.save(ciudadExistente);
    }

    public void eliminarCiudad(String id) {
        ciudadRepository.deleteById(id);
    }

    public List<Ciudad> getLista() {
        return ciudadRepository.findAll();
    }
}
