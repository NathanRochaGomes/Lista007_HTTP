package com.example.Lista007_HTTP.jogadores.service;

import com.example.Lista007_HTTP.jogadores.entities.Jogador;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class jogadorService {
    List<Jogador> principais = new ArrayList<>();
    List<Jogador> reservas = new ArrayList<>();


    // Construtor para inicializar os jogadores principais e reservas
    public jogadorService() {
        principais.add(new Jogador("Alisson", "Goleiro", 31));
        principais.add(new Jogador("Danilo", "Lateral Direito", 32));
        principais.add(new Jogador("Marquinhos", "Zagueiro", 29));
        principais.add(new Jogador("Gabriel M.", "Zagueiro", 26));
        principais.add(new Jogador("Guilherme", "Lateral Esquerdo", 27));
        principais.add(new Jogador("Casemiro", "Volante", 31));
        principais.add(new Jogador("Bruno G.", "Meia", 26));
        principais.add(new Jogador("Rodrygo", "Meia-atacante", 23));
        principais.add(new Jogador("Raphinha", "Ponta Direita", 27));
        principais.add(new Jogador("Vinícius", "Ponta Esquerda", 23));
        principais.add(new Jogador("Endrick", "Centroavante", 18));

        reservas.add(new Jogador("Bento", "Goleiro",24));
        reservas.add(new Jogador("Militão","Zagueiro",26));
        reservas.add(new Jogador("Gerson",  "Volante",27));
        reservas.add(new Jogador("Lucas P.", "Meia",31));
        reservas.add(new Jogador("Gabigol", "Centroavante", 27));
    }

    // PUT /principal/jogador/{posicao}
    public String substituir(String posicao) {
        int indice = -1;
        for (int i = 0; i < principais.size(); i++) {
            if (principais.get(i).getPosicao().equalsIgnoreCase(posicao)) {
                indice = i;
                break;
            }
        }
        if (indice == -1) {
            return "Nenhum jogador encontrado na posição: " + posicao;
        }
        if (reservas.isEmpty()) {
            return "Não há reservas disponíveis";
        }
        Jogador reserva = reservas.remove(0);
        principais.set(indice, reserva);
        return "Substituição realizada! " + reserva.getNome() + " entrou na posição " + posicao;
    }
    public List<Jogador> getPrincipais() {
        return principais;
    }

    public List<Jogador> getReservas() {
        return reservas;
    }
}
