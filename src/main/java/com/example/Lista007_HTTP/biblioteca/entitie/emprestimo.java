package com.example.Lista007_HTTP.biblioteca.entitie;

import java.time.LocalDate;
import java.util.UUID;

public class emprestimo {
    private UUID emprestId;
    private livro livro;
    private String UsuarioID;
    private LocalDate dataEmprestimo;

    public emprestimo(livro livro, String usuarioID) {
        this.emprestId = UUID.randomUUID();
        this.livro = livro;
        this.UsuarioID = usuarioID;
        this.dataEmprestimo = LocalDate.now();
    }

    public UUID getEmprestId() {
        return emprestId;
    }

    public void setEmprestId(UUID emprestId) {
        this.emprestId = emprestId;
    }

    public livro getLivro() {
        return livro;
    }

    public void setLivro(livro livro) {
        this.livro = livro;
    }

    public String getUsuarioID() {
        return UsuarioID;
    }

    public void setUsuarioID(String usuarioID) {
        UsuarioID = usuarioID;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
}
