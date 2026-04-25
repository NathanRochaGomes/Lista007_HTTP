package com.example.Lista007_HTTP.biblioteca.service;

import com.example.Lista007_HTTP.biblioteca.entitie.emprestimo;
import com.example.Lista007_HTTP.biblioteca.entitie.livro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class biblioService {

    List<livro> livros = new ArrayList<>();
    List<emprestimo> emprestimos = new ArrayList<>();

    public biblioService() {
        livros.add(new livro("O Senhor dos Anéis", "J.R.R. Tolkien"));
        livros.add(new livro("1984", "George Orwell"));
        livros.add(new livro("A Guerra dos Tronos", "George R.R. Martin"));
        livros.add(new livro("O Espadachim de Carvão", "Affonso Solano"));
        livros.add(new livro("O Hobbit", "J.R.R. Tolkien"));
        livros.add(new livro("Duna", "Frank Herbert"));
        livros.add(new livro("Fundação", "Isaac Asimov"));
        livros.add(new livro("Neuromancer", "William Gibson"));
        livros.add(new livro("O Nome do Vento", "Patrick Rothfuss"));
        livros.add(new livro("Sapiens", "Yuval Noah Harari"));

        livro livro1 = livros.remove(0);
        livro livro2 = livros.remove(0);

        emprestimos.add(new emprestimo(livro1, "joao"));
        emprestimos.add(new emprestimo(livro2, "maria"));
    }

    // GET /livros
    public List<livro> getLivros() {
        return livros;
    }

    // GET /emprestados
    public List<emprestimo> getEmprestimos() {
        return emprestimos;
    }

    // POST /emprestados
    public String emprestar(UUID livroId, String usuarioId) {
        livro livro = livros.stream()
                .filter(l -> l.getId().equals(livroId))
                .findFirst()
                .orElse(null);

        if (livro == null) return "Livro não encontrado";

        emprestimos.add(new emprestimo(livro, usuarioId));
        livros.remove(livro);

        return "Empréstimo criado!";
    }

    // DELETE /emprestados/{emprestId}
    public String devolver(UUID emprestId) {
        emprestimo emp = emprestimos.stream()
                .filter(e -> e.getEmprestId().equals(emprestId))
                .findFirst()
                .orElse(null);

        if (emp == null) return "Empréstimo não encontrado";

        livros.add(emp.getLivro());
        emprestimos.remove(emp);

        return "Livro devolvido!";
    }
}