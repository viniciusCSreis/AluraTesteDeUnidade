package br.com.caelum.leilao.dominio;

class Avaliador {

    private double maiorDeTodos = Double.NEGATIVE_INFINITY;
    private double menorDeTodos = Double.POSITIVE_INFINITY;
    private double somaDeTodos ;
    private int quantidadeDeleilao;

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
    }

    public double getMaiorLance() { return maiorDeTodos; }
    public double getMenorLance() { return menorDeTodos; }
    public double getMediaLance() { return quantidadeDeleilao != 0 ? somaDeTodos/quantidadeDeleilao : 0.0; }
}