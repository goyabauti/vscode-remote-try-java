package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EjercitoTest {



    @Test
    void soldado_recibe_un_disparo_muere(){ //SOLDADO

        Soldado s1 = new Soldado();
        s1.setVida(1);
        assertTrue(s1.estaVivo());
        s1.recibirDisparo();
        assertEquals(false, s1.estaVivo());

        
    }//testa si un soldado al recibir un disparo, muere

    @Test
    void tanque_vive_un_disparo_muere_segundo() { //TANQUE
    Tanque t1 = new Tanque();
    t1.setVida(2);  // arranco con 2 de vida
    
    // primer disparo
    t1.recibirDisparo();
    assertEquals(1.0f, t1.getVida(), 1e-6f); // queda con 1 de vida
    assertTrue(t1.estaVivo());               // aca el tanque sigue vivo
    
    // segundo disparo
    t1.recibirDisparo();
    assertEquals(0.0f, t1.getVida(), 1e-6f); // le bajo la vida a 0
    assertFalse(t1.estaVivo());              // muerto
    }

    @Test
    void buque_muere_tres_disparos(){ //BUQUE
        Buque b1 = new Buque();
        b1.setVida(3);

        //primer disparo
        b1.recibirDisparo();
        assertEquals(2.0f, b1.getVida(), 1e-6f);
        assertTrue(b1.estaVivo()); // le queda 2 de vida

        //segundo disparo
        b1.recibirDisparo();
        assertEquals(1.0f, b1.getVida(), 1e-6f);
        assertTrue(b1.estaVivo()); // 1 de vida

        b1.recibirDisparo();
        assertEquals(0.0f, b1.getVida(), 1e-6f);
        assertFalse(b1.estaVivo()); // muere

    }

    @Test 
    void escudo_50_porciento(){

        Soldado s1 = new Soldado();
        Escudo e1 = new Escudo();

        e1.setEscudo(50);
        s1.setEscudo(e1);

        s1.recibirDisparo();
        assertEquals(0.5f, s1.getVida(), 1e-6f);
        assertTrue(s1.estaVivo()); //deberia quedar con 0.5 de via

        s1.recibirDisparo();
        assertEquals(0.0f, s1.getVida(), 1e-6f);
        assertTrue(s1.estaVivo()); //deberia estar muerto





    }
    







}



    


