package com.github.maikoncanuto.controllers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.github.maikoncanuto.controllers.AcaoJogo.ataqueDefesa;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AcaoJogoTest {

    @ParameterizedTest
    @CsvSource({"10, 10, 0", "100, 100, 0", "1000, 1000, 0"})
    void deveZerarDefesaComAtaqueIgualADefesa(Integer ataque, Integer defesa, Integer esperado) {
        Integer resultado = ataqueDefesa(defesa, ataque);
        assertEquals(esperado, resultado);
    }

    @ParameterizedTest
    @CsvSource({"10, 5, -5", "100, 99, -1"})
    void deveNegativarADefesaParaAfetarAVida(Integer ataque, Integer defesa, Integer esperado) {
        Integer resultado = ataqueDefesa(defesa, ataque);
        assertEquals(esperado, resultado);
    }
}