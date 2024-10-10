package com.talentoTech.communityNetwork.controllers;

import com.talentoTech.communityNetwork.entitys.Usuario;
import com.talentoTech.communityNetwork.services.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
    UsuarioService servicio = new UsuarioService();

    @GetMapping("/listarUsuarios")
    public ArrayList<Usuario> listar(){
        return servicio.getLista();
    }

    @GetMapping("/response")
    public String response (){
        return  "Respondiendo";
    }

    @PostMapping
    public String register(@RequestBody Usuario u){
         servicio.registerUsuario(u);
         return "Registro Exitoso";
    }
}
