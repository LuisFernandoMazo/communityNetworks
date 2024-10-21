package com.talentoTech.communityNetwork.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/comentarios")
public class ComentarioController {
    @GetMapping
    public String listar(){
        return "Listar";
    }

    @GetMapping("/response")
    public String response (){
        return  "Respondiendo";
    }
}
