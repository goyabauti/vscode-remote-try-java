package com.mycompany.app;


public abstract class Ejercito {
   // atributos
    private float vida; 
    private Escudo escudo;
    private ArmaBase arma;


  public Ejercito(){
   // constructor vacio

  }

  public Ejercito(float vida){
    this.vida = vida; 


  }

 public void setVida(float vida){
    this.vida = vida; 
    // metodo que permite asignar un valor a 'vida'
  } 


  public float getVida(){
    return vida;
    // devuelve vida

  } 

  public void setEscudo(Escudo escudo) {   
        this.escudo = escudo;
    }

    public Escudo getEscudo() {             
        return escudo;
     }

  public void setArma (ArmaBase arma){
      this.arma = arma;

    }

    public ArmaBase getArma(){
      return arma;
    }

    public void recibirDisparo(float danio){
      float efectivo = (escudo != null) ? escudo.reducirDaño(danio) : danio;
      vida = Math.max(vida - efectivo, 0.0f);

    }

    public void recibirDisparo(){
      recibirDisparo(1.0f);
    }

    public boolean estaVivo(){
      return vida > 0.0f;

    }

    public void disparar(Ejercito objetivo){

      float danio = (arma != null) ? arma.usar() : 1.0f;
      objetivo.recibirDisparo(danio); 

    }



}