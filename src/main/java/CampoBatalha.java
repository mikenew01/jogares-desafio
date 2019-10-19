import java.util.LinkedList;
import java.util.List;

import static java.lang.String.format;

public class CampoBatalha {

    /***
     * Método que efetua a batalha entre dois jogadores.
     *
     * Ele determina quem irá ser o primeiro jogador e o segundo com base no atributo do jogador.
     * No final retorna um objeto com resultado da batalha, jogador vencedor e perdedor e os logs da batalha durante o jogo.
     */
    public ResultadoJogo batalha(Jogador jogador1, Jogador jogador2) {
        List<String> logJogo = new LinkedList<String>();

        //Determina quem irá começar
        Jogador primeiroJogador = jogador1.getPrimeiroJogador() ? jogador1 : jogador2;
        Jogador segundoJogador = !jogador1.getPrimeiroJogador() ? jogador1 : jogador2;

        /**
         * Executa até alguém zerar ou negativar a vida.
         */
        do {
            if (primeiroJogador.getMinhaVez())
                luta(primeiroJogador, segundoJogador, logJogo);
            else
                luta(segundoJogador, primeiroJogador, logJogo);
        } while (primeiroJogador.getVida() > 0 && segundoJogador.getVida() > 0);

        //Envia o resultado do jogo.
        return resultado(primeiroJogador, segundoJogador, logJogo);
    }

    /***
     * Método para determinar o resultado jogo com base na vida do jogador.
     * E envia os logs da batalha.
     */
    private ResultadoJogo resultado(Jogador jogador1, Jogador jogador2, List<String> logJogo) {
        ResultadoJogo resultadoJogo = new ResultadoJogo();

        if (jogador1.getVida() == 0) {
            resultadoJogo.setJogadorPerdedor(jogador1);
            resultadoJogo.setJogadorVencedor(jogador2);
        } else {
            resultadoJogo.setJogadorPerdedor(jogador2);
            resultadoJogo.setJogadorVencedor(jogador1);
        }

        resultadoJogo.setLogBatalha(logJogo);

        return resultadoJogo;
    }

    /***
     * Método principal para efetua a luta do jogador. Recebe o jogador de ataque e defesa.
     * Também efetua a troca da VEZ, assim cada jogador terá sua vez.
     */
    private Jogador luta(Jogador jogadorAtacante, Jogador jogadorDefesa, List<String> logJogo) {
        if (jogadorAtacante.getAtaque() >= jogadorDefesa.getDefesa()) {
            Integer defesaRestante = jogadorDefesa.getDefesa() - jogadorAtacante.getAtaque();
            Integer vidaRestante = jogadorDefesa.getVida() + defesaRestante;
            jogadorDefesa.setVida(vidaRestante);
            jogadorDefesa.setDefesa(defesaRestante);

            logJogo.add(format("[Ataque] - %s atacou %s com %d de ataque, [defesa-restante: %d, vida-restante: %d]",
                    jogadorAtacante.getNickname(),
                    jogadorDefesa.getNickname(),
                    jogadorAtacante.getAtaque(),
                    defesaRestante,
                    vidaRestante));
        } else if (jogadorAtacante.getAtaque() < jogadorDefesa.getDefesa()) {
            Integer defesaRestante = jogadorDefesa.getDefesa() - jogadorAtacante.getAtaque();
            jogadorDefesa.setDefesa(defesaRestante);

            logJogo.add(format("[defesa] - %s atacou %s com %d de ataque, [defesa-restante: %d]",
                    jogadorAtacante.getNickname(),
                    jogadorDefesa.getNickname(),
                    jogadorAtacante.getAtaque(),
                    defesaRestante));
        }

        jogadorAtacante.setMinhaVez(Boolean.FALSE);
        jogadorDefesa.setMinhaVez(Boolean.TRUE);

        return jogadorDefesa;
    }

}
