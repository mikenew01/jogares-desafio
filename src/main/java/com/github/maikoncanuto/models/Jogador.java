package com.github.maikoncanuto.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jogador implements Serializable {

    private String nickname;
    private Integer ataque;
    private Integer defesa;
    private Integer vida;
    private Boolean primeiroJogador;
    private Boolean minhaVez;

    public Jogador(String nickname, Integer ataque, Integer defesa, Integer vida, Boolean primeiroJogador) {
        this.nickname = nickname;
        this.ataque = ataque;
        this.defesa = defesa;
        this.vida = vida;
        this.primeiroJogador = primeiroJogador;
        this.minhaVez = primeiroJogador;
    }
}
