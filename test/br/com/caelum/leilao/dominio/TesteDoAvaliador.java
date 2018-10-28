package br.com.caelum.leilao.dominio;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class TesteDoAvaliador {

    @Test
    public void deveEntenderLancesEmOrdemCrescente() {
        // cenario: 3 lances em ordem crescente
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");


        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(maria,250.0));
        leilao.propoe(new Lance(joao,300.0));
        leilao.propoe(new Lance(jose,400.0));

        // executando a acao
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        double maiorEsperado = 400;
        double menorEsperado = 250;

        Assertions.assertEquals(maiorEsperado,leiloeiro.getMaiorLance(),0.0001);
        Assertions.assertEquals(menorEsperado,leiloeiro.getMenorLance(),0.0001);
    }
}