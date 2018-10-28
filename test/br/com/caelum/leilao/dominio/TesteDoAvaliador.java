package br.com.caelum.leilao.dominio;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TesteDoAvaliador {

    @Test
    public void deveEntenderLancesEmOrdemCrescente() {
        // cenario: 3 lances em ordem crescente
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");


        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(maria, 250.0));
        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(jose, 400.0));

        // executando a acao
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        double maiorEsperado = 400;
        double menorEsperado = 250;

        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);

    }
    @Test
    public void deveEntenderLancesEmOrdemDecrescente() {
        // cenario: 3 lances em ordem crescente
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");


        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(maria, 400.0));
        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(jose, 200.0));
        leilao.propoe(new Lance(maria, 100.00));

        // executando a acao
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        double maiorEsperado = 400.0;
        double menorEsperado = 100.00;

        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);

    }
    @Test
    public void deveEntenderLancesEmOrdemAleatoria() {
        // cenario: 3 lances em ordem crescente
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");


        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(maria, 200));
        leilao.propoe(new Lance(joao, 450));
        leilao.propoe(new Lance(jose, 120));
        leilao.propoe(new Lance(maria, 700));
        leilao.propoe(new Lance(joao, 630));
        leilao.propoe(new Lance(jose, 230));

        // executando a acao
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        double maiorEsperado = 700;
        double menorEsperado = 120;

        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);

    }

    @Test
    public void deveEntenderLeilaoComApenasUmLance() {
        Usuario joao = new Usuario("Joao");
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao,1000.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        assertEquals(1000, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(1000, leiloeiro.getMenorLance(), 0.0001);
    }

    @Test
    public void deveEncontrarOsTresMaioresLancesDe5Lances() {
        Usuario joao = new Usuario("João");
        Usuario maria = new Usuario("Maria");
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(maria, 200.0));
        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(maria, 400.0));
        leilao.propoe(new Lance(joao, 500.00));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        assertEquals(3, maiores.size());
        assertEquals(500, maiores.get(0).getValor(), 0.00001);
        assertEquals(400, maiores.get(1).getValor(), 0.00001);
        assertEquals(300, maiores.get(2).getValor(), 0.00001);
    }

    @Test
    public void deveEncontrarOsTresMaioresLancesDe2Lances() {
        Usuario joao = new Usuario("João");
        Usuario maria = new Usuario("Maria");
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(maria, 200.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        assertEquals(2, maiores.size());
        assertEquals(200, maiores.get(0).getValor(), 0.00001);
        assertEquals(100, maiores.get(1).getValor(), 0.00001);
    }
    @Test
    public void deveEncontrarOsTresMaioresLancesDe0Lances() {
        Usuario joao = new Usuario("João");
        Usuario maria = new Usuario("Maria");
        Leilao leilao = new Leilao("Playstation 3 Novo");


        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        assertEquals(0, maiores.size());
    }



    @Test
    public void deveCalcularAMedia() {
        // cenario: 3 lances em ordem crescente
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(maria,300.0));
        leilao.propoe(new Lance(joao,400.0));
        leilao.propoe(new Lance(jose,500.0));

        // executando a acao
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        // comparando a saida com o esperado
        assertEquals(400, leiloeiro.getMediaLance(), 0.0001);
    }

    @Test
    public void testaMediaDeZeroLance(){

        // cenario
        Usuario ewertom = new Usuario("Ewertom");

        // acao
        Leilao leilao = new Leilao("Iphone 7");

        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao);

        //validacao
        assertEquals(0, avaliador.getMediaLance(), 0.0001);

    }
}