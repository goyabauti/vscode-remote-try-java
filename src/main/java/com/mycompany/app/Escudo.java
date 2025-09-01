package com.mycompany.app;

public class Escudo {

    private float porcentajeEscudo;

    public float getEscudo(){
        return porcentajeEscudo; // nos devuelve el procentaje del escudo
    }

    public void setEscudo(int porcentajeEscudo){
        this.porcentajeEscudo = porcentajeEscudo; //el porcentaje del escudo del getter es el % de escudo que se setea
    }

    public float reducirDaño(float dañoOriginal){
        return (dañoOriginal * (100 - porcentajeEscudo) / 100); //Escudo = 50% reducirDaño(1) = 1 * (100 - 50) / 100 = 0.5. Bloquea la mitad, pasa medio punto de daño
    }
}
