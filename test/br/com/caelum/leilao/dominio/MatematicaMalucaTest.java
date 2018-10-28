package br.com.caelum.leilao.dominio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatematicaMalucaTest {

    @Test
    public void numeroMaior30()
    {
        MatematicaMaluca matematicaMaluca = new MatematicaMaluca();

        assertEquals( 31*4 , matematicaMaluca.contaMaluca(31),0.00001);

    }
    @Test
    public void numeroIgual30()
    {
        MatematicaMaluca matematicaMaluca = new MatematicaMaluca();

        assertEquals( 30*3 , matematicaMaluca.contaMaluca(30),0.00001);

    }
    @Test
    public void numeroEntre10e31()
    {
        MatematicaMaluca matematicaMaluca = new MatematicaMaluca();

        assertEquals( 29*3 , matematicaMaluca.contaMaluca(29),0.00001);

    }
    @Test
    public void numeroIgual10()
    {
        MatematicaMaluca matematicaMaluca = new MatematicaMaluca();

        assertEquals( 10*2 , matematicaMaluca.contaMaluca(10),0.00001);

    }
    @Test
    public void numeroMenor10()
    {
        MatematicaMaluca matematicaMaluca = new MatematicaMaluca();

        assertEquals( 9*2 , matematicaMaluca.contaMaluca(9),0.00001);

    }

}
