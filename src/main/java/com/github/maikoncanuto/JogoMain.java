package com.github.maikoncanuto;

import com.github.maikoncanuto.models.Jogador;
import com.github.maikoncanuto.models.ResultadoJogo;

import java.util.Random;

import static com.github.maikoncanuto.controllers.CampoBatalha.batalha;

public class JogoMain {

    public static void main(String[] args) {
        Boolean primeiroJogador = new Random().nextBoolean();

        Jogador jogador1 = new Jogador("tony.stark", 145, 125, 100, primeiroJogador);
        Jogador jogador2 = new Jogador("thanos", 125, 150, 100, !primeiroJogador);

        ResultadoJogo resultadoJogo = batalha(jogador1, jogador2);

        System.out.println("Vencedor: " + resultadoJogo.getJogadorVencedor().getNickname());
        System.out.println("Perdedor: " + resultadoJogo.getJogadorPerdedor().getNickname());

        resultadoJogo.getLogBatalha().forEach(System.out::println);
    }
}
