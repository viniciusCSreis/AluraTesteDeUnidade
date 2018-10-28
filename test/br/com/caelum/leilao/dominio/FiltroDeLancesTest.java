package br.com.caelum.leilao.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class FiltroDeLancesTest {

    @Test
    public void deveSelecionarLancesEntre1000E3000() {
        Usuario joao = new Usuario("Joao");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao,2000),
                new Lance(joao,1000),
                new Lance(joao,3000),
                new Lance(joao, 800)));

        assertEquals(1, resultado.size());
        assertEquals(2000, resultado.get(0).getValor(), 0.00001);
    }

    @Test
    public void deveSelecionarLancesEntre500E700() {
        Usuario joao = new Usuario("Joao");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao,600),
                new Lance(joao,500),
                new Lance(joao,700),
                new Lance(joao, 800)));

        assertEquals(1, resultado.size());
        assertEquals(600, resultado.get(0).getValor(), 0.00001);
    }
    @Test
    public void deveSelecionarLancesMaiorque5000() {
        Usuario joao = new Usuario("Joao");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao,1000),
                new Lance(joao,3000),
                new Lance(joao,500),
                new Lance(joao, 700),
                new Lance(joao, 5000),
                new Lance(joao, 5001)
        ));

        assertEquals(1, resultado.size());
        assertEquals(5001, resultado.get(0).getValor(), 0.00001);
    }
    @Test
    public void deveSelecionarLancesMenorque500() {
        Usuario joao = new Usuario("Joao");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao, 499),
                new Lance(joao, 500)
        ));

        assertEquals(0, resultado.size());
    }
    @Test
    public void deveSelecionarLancesEntre700e1000() {
        Usuario joao = new Usuario("Joao");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao, 701),
                new Lance(joao, 700),
                new Lance(joao, 1000),
                new Lance(joao, 999)
        ));

        assertEquals(0, resultado.size());
    }
    @Test
    public void deveSelecionarLancesEntre3000e5000() {
        Usuario joao = new Usuario("Joao");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao, 3000),
                new Lance(joao, 3001),
                new Lance(joao, 5000)
        ));

        assertEquals(0, resultado.size());
    }
}
