package com.example.Lista007_HTTP.biblioteca.controller;

import com.example.Lista007_HTTP.biblioteca.service.biblioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/livros")
public class bibliotecaController {
    @Autowired
    biblioService service;

    @PostMapping("/emprestados")
    public String emprestarLivro(@RequestParam UUID livroId,
                                 @RequestParam String usuarioId) {
        return service.emprestar(livroId, usuarioId);
    }
}
