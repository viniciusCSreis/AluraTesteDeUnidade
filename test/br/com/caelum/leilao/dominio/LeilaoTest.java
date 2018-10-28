package br.com.caelum.leilao.dominio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeilaoTest {

    @Test
    public void proproe1lance(){
        Leilao leilao = new Leilao("Samsung S5 4g");

        assertEquals(0, leilao.getLances().size());

        leilao.propoe(new Lance(new Usuario("Vinicius"),2000));

        assertEquals(1, leilao.getLances().size());
        assertEquals(2000, leilao.getLances().get(0).getValor());

    }

    @Test
    public void proproe2lance(){
        Leilao leilao = new Leilao("Samsung S5 4g");

        assertEquals(0, leilao.getLances().size());

        leilao.propoe(new Lance(new Usuario("Vinicius"),2000));
        leilao.propoe(new Lance(new Usuario("Clemente"),3000));

        assertEquals(2, leilao.getLances().size());
        assertEquals(2000, leilao.getLances().get(0).getValor());
        assertEquals(3000, leilao.getLances().get(1).getValor());

    }

    @Test
    public void usuarioNaoDevePropor2VezesSeguindas()
    {
        Leilao leilao = new Leilao("Samsungs S5 4g");
        Usuario vinicius = new Usuario("Vinicius");
        assertEquals(0 , leilao.getLances().size());

        leilao.propoe(new Lance(vinicius,2000));
        leilao.propoe(new Lance(vinicius,3000));

        assertEquals(1, leilao.getLances().size());
        assertEquals(2000, leilao.getLances().get(0).getValor());

    }

    @Test
    public void naoDeveAceitarMaisDoQue5LancesDoMesmoUsuario()
    {
        Leilao leilao = new Leilao("Samsungs S5 4g");
        Usuario vinicius = new Usuario("Vinicius");
        Usuario clemente = new Usuario("Clemente");

        leilao.propoe(new Lance(vinicius,2000));
        leilao.propoe(new Lance(clemente,3000));

        leilao.propoe(new Lance(vinicius,4000));
        leilao.propoe(new Lance(clemente,5000));

        leilao.propoe(new Lance(vinicius,6000));
        leilao.propoe(new Lance(clemente,7000));

        leilao.propoe(new Lance(vinicius,8000));
        leilao.propoe(new Lance(clemente,9000));

        leilao.propoe(new Lance(vinicius,10000));
        leilao.propoe(new Lance(clemente,11000));

        //deve ser ignorado
        leilao.propoe(new Lance(vinicius,12000));

        assertEquals(10, leilao.getLances().size());
        assertEquals(11000, leilao.pegarUltimoLance().getValor());

    }

}
