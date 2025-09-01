package com.mycompany.app;

public abstract class Ejercito {
   // atributos
    private int vida; 
    private Escudo escudo;


public Ejercito(){
   // constructor vacio

}

public Ejercito(int vida){
    this.vida = vida; 
    this.escudo = escudo;

}

public int getVida(){
    return vida;
    // devuevle vida

} 

public void setVida(int vida){
    this.vida = vida; 
    // metodo que permite asignar un valor a 'vida'
} 

public void setEscudo(Escudo escudo) {   
        this.escudo = escudo;
    }

    public Escudo getEscudo() {             
        return escudo;
    }


 public void recibirDisparo(){

    float daño = 1.00f;

    if (escudo != null){
      daño = escudo.reducirDaño(daño);
    }
      vida -= daño;
  }

  public boolean estaVivo(){
    
    if (vida > 0.000f){
      return true;
    }
    else{
      return false;
    }
  }
  

 // Todos disparan (1 de daño base)
public void disparar(Ejercito objetivo){
    objetivo.recibirDisparo();

}



}