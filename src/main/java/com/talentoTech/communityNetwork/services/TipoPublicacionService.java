package com.talentoTech.communityNetwork.services;

import com.talentoTech.communityNetwork.entitys.TipoPublicacion;
import com.talentoTech.communityNetwork.repository.TipoPublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoPublicacionService {

    @Autowired
    private TipoPublicacionRepository tipoPublicacionRepository;

    public TipoPublicacion crearTipoPublicacion(TipoPublicacion publicacion) {
        return tipoPublicacionRepository.save(publicacion);
    }
}