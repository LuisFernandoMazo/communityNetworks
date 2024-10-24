package com.talentoTech.communityNetwork.controllers;

import com.talentoTech.communityNetwork.entitys.Usuario;

import com.talentoTech.communityNetwork.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/response")
    public String response (){
        return  "Respondiendo";
    }

    @PostMapping("/registro")
    public ResponseEntity<String> registrarUsuario(@RequestBody Usuario usuario){
        try{
            usuarioService.registerUsuario(usuario);
            return new ResponseEntity<>("Usuario registrado exitosamente", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/buscarUsuario/{cedula}")
    public ResponseEntity<Usuario> registrarUsuario(@PathVariable String cedula){
        try{
            Optional<Usuario> usuario = usuarioService.findByIdUser(cedula);
            return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
