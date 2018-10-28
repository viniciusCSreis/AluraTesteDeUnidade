package br.com.caelum.leilao.dominio;

import java.util.List;
import java.util.ArrayList;

class Avaliador {

    private double maiorDeTodos = Double.NEGATIVE_INFINITY;
    private double menorDeTodos = Double.POSITIVE_INFINITY;
    private double somaDeTodos ;
    private int quantidadeDeleilao;
    private List<Lance> maiores;

    public void avalia(Leilao leilao) {
        somaDeTodos = 0;
        quantidadeDeleilao = leilao.getLances().size();

        for(Lance lance : leilao.getLances()) {
            if(lance.getValor() > maiorDeTodos) {
                maiorDeTodos = lance.getValor();
            }
            if(lance.getValor() < menorDeTodos) {
                menorDeTodos = lance.getValor();
            }
            somaDeTodos += lance.getValor();
        }
        pegaOsMaioresNo(leilao);
    }
    private void pegaOsMaioresNo(Leilao leilao) {
        maiores = new ArrayList<>(leilao.getLances());
        maiores.sort((o1, o2) -> (int) (o2.getValor() - o1.getValor()));
        maiores = maiores.subList(0, maiores.size() >= 3 ? 3 : maiores.size());
    }

    public List<Lance> getTresMaiores() {
        return this.maiores;
    }


    public double getMaiorLance() { return maiorDeTodos; }
    public double getMenorLance() { return menorDeTodos; }
    public double getMediaLance() { return quantidadeDeleilao != 0 ? somaDeTodos/quantidadeDeleilao : 0.0; }
}