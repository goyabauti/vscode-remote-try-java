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
        assertTrue(t1.estaVivo()); // aca el tanque sigue vivo
    
        // segundo disparo
        t1.recibirDisparo();
        assertEquals(0.0f, t1.getVida(), 1e-6f); // le bajo la vida a 0
        assertFalse(t1.estaVivo());  // muerto
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
    void escudo_50_porciento_soldado(){

        Soldado s1 = new Soldado();
        Escudo e1 = new Escudo();

        e1.setEscudo(50);
        s1.setEscudo(e1); // al soldado (s1) le doy el escudo (e1)

        s1.recibirDisparo();
        assertEquals(0.5f, s1.getVida(), 1e-6f);
        assertTrue(s1.estaVivo()); //deberia quedar con 0.5 de via

        s1.recibirDisparo();
        assertEquals(0.0f, s1.getVida(), 1e-6f);
        assertFalse(s1.estaVivo()); //deberia estar muerto

    }
    
    @Test
    void escudo_50_porciento_tanque(){

        Tanque t1 = new Tanque();
        Escudo e1 = new Escudo();

        e1.setEscudo(50);
        t1.setEscudo(e1); // al tanque (e1) le doy el escudo (e1)

        t1.recibirDisparo();
        assertEquals(1.50f, t1.getVida(), 1e-6f);
        assertTrue(t1.estaVivo());

        t1.recibirDisparo();
        assertEquals(1.0f, t1.getVida(), 1e-6f);
        assertTrue(t1.estaVivo());

        t1.recibirDisparo();
        assertEquals(0.5f, t1.getVida(), 1e-6f);
        assertTrue(t1.estaVivo());

        t1.recibirDisparo();
        assertEquals(0.0f, t1.getVida(), 1e-6f);
        assertFalse(t1.estaVivo()); // termina muriendo de 4 disparos

    }

    @Test
    void escudo_50_porciento_buque(){

        Buque b1 = new Buque();
        Escudo e1 = new Escudo();

        e1.setEscudo(50);
        b1.setEscudo(e1); // al buque (b1) le doy el escudo (e1)

        b1.recibirDisparo();
        assertEquals(2.50f, b1.getVida(), 1e-6f);
        assertTrue(b1.estaVivo());

        b1.recibirDisparo();
        assertEquals(2.0f, b1.getVida(), 1e-6f);
        assertTrue(b1.estaVivo());

        b1.recibirDisparo();
        assertEquals(1.50f, b1.getVida(), 1e-6f);
        assertTrue(b1.estaVivo());

        b1.recibirDisparo();
        assertEquals(1.0f, b1.getVida(), 1e-6f);
        assertTrue(b1.estaVivo());

        b1.recibirDisparo();
        assertEquals(0.5f, b1.getVida(), 1e-6f);
        assertTrue(b1.estaVivo());

        b1.recibirDisparo();
        assertEquals(0.0f, b1.getVida(), 1e-6f);
        assertFalse(b1.estaVivo()); // termina muriendo de 6 disparos

        

            
    }

    @Test
    void soldado_dispara_tanque_con_pistola(){

        Soldado sp = new Soldado();
        Tanque tp = new Tanque();
        ArmaPistola pistola = new ArmaPistola();

        sp.setArma(pistola); // al soldado pistola (sp) le doy el arma pistola

        assertEquals(10, pistola.getMunicion());

        sp.disparar(tp); //aca hago que el soldado le dispare al tanque con la pistola

        assertEquals(1.0f, tp.getVida(), 1e-6f);
        assertEquals(9, pistola.getMunicion());

        //seguir hasta que el tanque muera

        sp.disparar(tp);

        assertEquals(0.0f, tp.getVida(), 1e-6f);
        assertEquals(8, pistola.getMunicion());
        assertFalse(tp.estaVivo());

    }


    @Test
    void tanque_dispara_buque_con_bomba(){

        Tanque tb = new Tanque();
        Buque bb = new Buque();
        ArmaBomba bomba = new ArmaBomba();


        tb.setArma(bomba); //al tanque le doy la bomba

        assertEquals(4, bomba.getMunicion()); //preparo la bomba

        tb.disparar(bb); //el tanque le dispara al buque con la bomba

        assertEquals(1.0f, bb.getVida());
        assertEquals(3, bomba.getMunicion()); //buque queda con 1 de vida

        //sigo hasta que el tanque muera

        tb.disparar(bb); //dispara nuevamente

        assertEquals(0.0f, bb.getVida());
        assertEquals(2, bomba.getMunicion());
        assertFalse(bb.estaVivo());

    }

    @Test
    void buque_dispara_tanque_con_canon(){

        Buque bc = new Buque();
        Tanque tc = new Tanque();
        ArmaCanon canon = new ArmaCanon();

        bc.setArma(canon); //al buque le doy el canon

        assertEquals(7, canon.getMunicion()); //preparo el canon

        bc.disparar(tc); 

        assertEquals(0.5f, tc.getVida());
        assertEquals(6, canon.getMunicion()); 
        assertTrue(tc.estaVivo()); //tanque queda con 0.5 de vida

        //sigo hasta que el tanque muere
        
         bc.disparar(tc); 

         assertEquals(0.0f, tc.getVida());
         assertEquals(5, canon.getMunicion());
         assertFalse(tc.estaVivo());

    }


    @Test
    void soldado_dispara_buque_con_escudo_con_bomba(){

        Soldado sb = new Soldado();
        Buque be = new Buque();
        Escudo e1 = new Escudo();
        ArmaBomba bomba = new ArmaBomba();

        sb.setArma(bomba);
        e1.setEscudo(75);
        be.setEscudo(e1);
        
        sb.disparar(be); //soldado con bomba dispara a buque con escudo

        assertEquals(2.5f, be.getVida());
        assertEquals(3, bomba.getMunicion());
        assertTrue(be.estaVivo());

        e1.setEscudo(0);
        be.setEscudo(e1); //ahora le saco el escudo al buque

        sb.disparar(be); // le disparo sin escudo

        assertEquals(0.5f, be.getVida());
        assertEquals(2, bomba.getMunicion());
        assertTrue(be.estaVivo());

        sb.disparar(be); //disparo a matar el buque

        assertEquals(0.0f, be.getVida());
        assertEquals(1, bomba.getMunicion());
        assertFalse(be.estaVivo());


    }


}



    


