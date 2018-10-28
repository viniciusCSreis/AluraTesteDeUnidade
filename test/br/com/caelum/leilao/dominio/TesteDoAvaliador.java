package br.com.caelum.leilao.dominio;


import br.com.caelum.leilao.dominio.builder.LeilaoBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TesteDoAvaliador {

    private Avaliador leiloeiro;
    private Usuario joao;
    private Usuario jose;
    private Usuario maria;

    @BeforeEach
    public void init(){

        this.leiloeiro = new Avaliador();
        this.joao = new Usuario("Joao");
        this.jose = new Usuario("José");
        this.maria = new Usuario("Maria");
    }

    @Test
    public void deveEntenderLancesEmOrdemCrescente() {


        Leilao leilao= new LeilaoBuilder().para("Playstation 3 Novo")
                .lance(maria, 250.0)
                .lance(joao, 300.0)
                .lance(jose, 400.0)
                .constroi();

        // executando a acao
        leiloeiro.avalia(leilao);

        double maiorEsperado = 400;
        double menorEsperado = 250;

        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);

    }
    @Test
    public void deveEntenderLancesEmOrdemDecrescente() {


        Leilao leilao= new LeilaoBuilder().para("Playstation 3 Novo")
                .lance(maria, 400.0)
                .lance(joao, 300.0)
                .lance(jose, 200.0)
                .lance(maria, 100.00)
                .constroi();

        leiloeiro.avalia(leilao);

        double maiorEsperado = 400.0;
        double menorEsperado = 100.00;

        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);

    }
    @Test
    public void deveEntenderLancesEmOrdemAleatoria() {

        Leilao leilao= new LeilaoBuilder().para("Playstation 3 Novo")
                .lance(maria, 200)
                .lance(joao, 450)
                .lance(jose, 120)
                .lance(maria, 700)
                .lance(joao, 630)
                .lance(jose, 230)
                .constroi();

        leiloeiro.avalia(leilao);

        double maiorEsperado = 700;
        double menorEsperado = 120;

        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);

    }

    @Test
    public void deveEntenderLeilaoComApenasUmLance() {


        Leilao leilao= new LeilaoBuilder().para("Playstation 3 Novo")
                .lance(joao, 1000.0)
                .constroi();

        leiloeiro.avalia(leilao);

        assertEquals(1000, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(1000, leiloeiro.getMenorLance(), 0.0001);
    }

    @Test
    public void deveEncontrarOsTresMaioresLancesDe5Lances() {

        Leilao leilao= new LeilaoBuilder().para("Playstation 3 Novo")
                .lance(joao, 100.0)
                .lance(maria, 200.0)
                .lance(joao, 300.0)
                .lance(maria, 400.0)
                .lance(joao, 500.0)
                .constroi();

        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        assertEquals(3, maiores.size());
        assertEquals(500, maiores.get(0).getValor(), 0.00001);
        assertEquals(400, maiores.get(1).getValor(), 0.00001);
        assertEquals(300, maiores.get(2).getValor(), 0.00001);
    }

    @Test
    public void deveEncontrarOsTresMaioresLancesDe2Lances() {

        Leilao leilao= new LeilaoBuilder().para("Playstation 3 Novo")
                .lance(joao, 100.0)
                .lance(maria, 200.0)
                .constroi();

        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        assertEquals(2, maiores.size());
        assertEquals(200, maiores.get(0).getValor(), 0.00001);
        assertEquals(100, maiores.get(1).getValor(), 0.00001);
    }
    @Test
    public void deveEncontrarOsTresMaioresLancesDe0Lances() {

        Leilao leilao= new LeilaoBuilder().para("Playstation 3 Novo").constroi();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        assertEquals(0, maiores.size());
    }



    @Test
    public void deveCalcularAMedia() {

        Leilao leilao= new LeilaoBuilder().para("Playstation 3 Novo")
                .lance(joao, 300.0)
                .lance(maria, 400.0)
                .lance(jose, 500.0)
                .constroi();

        leiloeiro.avalia(leilao);


        // comparando a saida com o esperado
        assertEquals(400, leiloeiro.getMediaLance(), 0.0001);
    }

    @Test
    public void testaMediaDeZeroLance(){

        Leilao leilao= new LeilaoBuilder().para("Playstation 3 Novo").constroi();
        leiloeiro.avalia(leilao);

        //validacao
        assertEquals(0, leiloeiro.getMediaLance(), 0.0001);

    }
}