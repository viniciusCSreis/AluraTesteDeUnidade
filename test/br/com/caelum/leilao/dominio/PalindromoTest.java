package br.com.caelum.leilao.dominio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PalindromoTest {


    @Test
    public void reconhecePalindromo(){

        Palindromo palindromo = new Palindromo();
        String frase1 = "Socorram-me subi no onibus em Marrocos";
        String frase2 = "Anotaram a data da maratona";

        Assertions.assertEquals(true,palindromo.ehPalindromo(frase1));
        Assertions.assertEquals(true,palindromo.ehPalindromo(frase2));

    }

    @Test
    public void reconheceNaoPalindromo(){

        Palindromo palindromo = new Palindromo();
        String frase1 = "Frase normal";
        String frase2 = "Outra frase normal";

        Assertions.assertEquals(false,palindromo.ehPalindromo(frase1));
        Assertions.assertEquals(false,palindromo.ehPalindromo(frase2));

    }

    //alura code

    @Test
    public void deveIdentificarPalindromoEFiltrarCaracteresInvalidos() {
        Palindromo p = new Palindromo();

        boolean resultado = p.ehPalindromo(
                "Socorram-me subi no onibus em Marrocos");
        Assertions.assertTrue(resultado);
    }
    @Test
    public void deveIdentificarPalindromo() {
        Palindromo p = new Palindromo();

        boolean resultado = p.ehPalindromo(
                "Anotaram a data da maratona");
        Assertions.assertTrue(resultado);
    }

    @Test
    public void deveIdentificarSeNaoEhPalindromo() {
        Palindromo p = new Palindromo();

        boolean resultado = p.ehPalindromo(
                "E preciso amar as pessoas como se nao houvesse amanha");
        Assertions.assertFalse(resultado);
    }

}
