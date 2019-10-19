package com.github.maikoncanuto.controllers;

import com.github.maikoncanuto.models.Jogador;
import com.github.maikoncanuto.models.ResultadoJogo;

import java.util.LinkedList;
import java.util.List;

import static com.github.maikoncanuto.controllers.AcaoJogo.luta;

public class CampoBatalha {

    private CampoBatalha() {}

    public static ResultadoJogo batalha(Jogador jogador1, Jogador jogador2) {
        List<String> logJogo = new LinkedList<>();

        Jogador primeiroJogador = jogador1.getPrimeiroJogador() ? jogador1 : jogador2;
        Jogador segundoJogador = !jogador1.getPrimeiroJogador() ? jogador1 : jogador2;

        do {
            if (primeiroJogador.getMinhaVez())
                luta(primeiroJogador, segundoJogador, logJogo);
            else
                luta(segundoJogador, primeiroJogador, logJogo);
        } while (primeiroJogador.getVida() > 0 && segundoJogador.getVida() > 0);

        return resultado(primeiroJogador, segundoJogador, logJogo);
    }

    private static ResultadoJogo resultado(Jogador jogador1, Jogador jogador2, List<String> logJogo) {
        ResultadoJogo resultadoJogo = new ResultadoJogo();

        if (jogador1.getVida() == 0)
            determinarVencedores(jogador2, jogador1, resultadoJogo);
        else
            determinarVencedores(jogador1, jogador2, resultadoJogo);

        resultadoJogo.setLogBatalha(logJogo);

        return resultadoJogo;
    }

    private static void determinarVencedores(Jogador vencedor, Jogador perdedor, ResultadoJogo resultadoJogo) {
        resultadoJogo.setJogadorVencedor(vencedor);
        resultadoJogo.setJogadorPerdedor(perdedor);
    }
}
