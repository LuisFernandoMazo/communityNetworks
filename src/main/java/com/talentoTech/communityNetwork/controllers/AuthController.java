package com.talentoTech.communityNetwork.controllers;

import com.talentoTech.communityNetwork.dto.LoginRequest;
import com.talentoTech.communityNetwork.security.JwtUtil;
import com.talentoTech.communityNetwork.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UsuarioService usuarioService; // Servicio que valida el usuario

    @Autowired
    private JwtUtil jwtUtil;  // Inyectamos JwtUtil para generar el token

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        boolean isAuthenticated = usuarioService.validateUser(loginRequest.getCorreo(), loginRequest.getContrasena());

        if(isAuthenticated){
            String token = jwtUtil.generateToken(loginRequest.getCorreo());

            return ResponseEntity.ok("Token: "+token);
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }

}
