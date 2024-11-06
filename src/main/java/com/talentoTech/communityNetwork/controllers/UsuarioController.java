package com.talentoTech.communityNetwork.controllers;

import com.talentoTech.communityNetwork.dto.UsuarioDTO;
import com.talentoTech.communityNetwork.entitys.Usuario;

import com.talentoTech.communityNetwork.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
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
            return ResponseEntity.ok(null);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/buscarUsuario/{cedula}")
    public ResponseEntity<UsuarioDTO> registrarUsuario(@PathVariable String cedula){
        try{
            UsuarioDTO usuario = usuarioService.findByIdUser(cedula);
            return ResponseEntity.ok(usuario);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/profileUsuario/{cedula}")
    public ResponseEntity<UsuarioDTO> profileUser(@PathVariable String cedula){
        try{
            UsuarioDTO usuario = usuarioService.dataProfileUser(cedula);
            return ResponseEntity.ok(usuario);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
