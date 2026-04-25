package com.example.Lista007_HTTP.jogadores.controller;

import com.example.Lista007_HTTP.jogadores.entities.Jogador;
import com.example.Lista007_HTTP.jogadores.service.jogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/principal")
public class jogadorController {

    @Autowired
    jogadorService service;

    @GetMapping
    public List<Jogador> getPrincipais() {
        return service.getPrincipais();
    }

     @GetMapping("/reserva")
    public List<Jogador> getReservas() {
         return service.getReservas();
    }


    @PutMapping("/jogador/{posicao}")
    public String substituirJogador(@PathVariable String posicao) {
        return service.substituir(posicao);
    }
}
