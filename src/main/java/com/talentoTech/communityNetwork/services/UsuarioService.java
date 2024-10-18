package com.talentoTech.communityNetwork.services;

import com.talentoTech.communityNetwork.entitys.Departamento;
import com.talentoTech.communityNetwork.entitys.Usuario;
import com.talentoTech.communityNetwork.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsuarioService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    private ArrayList<Usuario> lista = new ArrayList<Usuario>();

    public UsuarioService() {
        lista.add(new Usuario("1193055118", "Luis Fernando ", "Mazo Cañas", "3207192827", "lfdo.mazoc@anteia.co","123456"));
    }

    public ArrayList<Usuario> getLista() {
        return lista;
    }

    public void registerUsuario(Usuario u){
        lista.add(u);
    }
}
