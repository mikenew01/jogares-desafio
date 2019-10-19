package com.github.maikoncanuto.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultadoJogo implements Serializable {

    private Jogador jogadorVencedor;
    private Jogador jogadorPerdedor;
    private List<String> logBatalha = new LinkedList<>();

}
