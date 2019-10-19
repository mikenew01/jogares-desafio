package com.github.maikoncanuto.controllers;

import com.github.maikoncanuto.models.Jogador;

import java.util.List;

import static java.lang.String.format;

public class AcaoJogo {

    private AcaoJogo() {}

    public static void luta(Jogador atacante, Jogador defensor, List<String> logJogo) {
        if (atacante.getAtaque() >= defensor.getDefesa()) {
            Integer defesaRestante = ataqueDefesa(defensor.getDefesa(), atacante.getAtaque());
            Integer vidaRestante = atualizarVida(defensor.getVida(), defesaRestante);
            defensor.setVida(vidaRestante);
            defensor.setDefesa(defesaRestante);

            logJogo.add(format("[Ataque] - %s atacou %s com %d de ataque, [defesa-restante: %d, vida-restante: %d]",
                    atacante.getNickname(),
                    defensor.getNickname(),
                    atacante.getAtaque(),
                    defesaRestante,
                    vidaRestante));
        } else if (atacante.getAtaque() < defensor.getDefesa()) {
            Integer defesaRestante = ataqueDefesa(defensor.getDefesa(), atacante.getAtaque());
            defensor.setDefesa(defesaRestante);

            logJogo.add(format("[defesa] - %s atacou %s com %d de ataque, [defesa-restante: %d]",
                    atacante.getNickname(),
                    defensor.getNickname(),
                    atacante.getAtaque(),
                    defesaRestante));
        }

        trocarVez(atacante, defensor);
    }

    public static Integer ataqueDefesa(Integer defesa, Integer ataque) {
        return defesa - ataque;
    }

    public static Integer atualizarVida(Integer vida, Integer defesa) {
        return vida + defesa;
    }

    public static void trocarVez(Jogador jogador1, Jogador jogador2) {
        jogador1.setMinhaVez(!jogador1.getMinhaVez());
        jogador2.setMinhaVez(!jogador2.getMinhaVez());
    }
}
