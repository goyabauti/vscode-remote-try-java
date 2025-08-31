package com.mycompany.app;

public abstract class Ejercito {
   // atributos
    public int vida;


public Ejercito(){
   // constructor vacio

}

public Ejercito(int vida){
    this.vida = vida; 

}

public int getvida(){
    return vida;
    // devuevle vida

} 

public void setvida(int vida){
    this.vida = vida; 
    // metodo que permite asignar un valor a 'vida'
} 

 // Todos disparan (1 de daño base)
public void disparar(Ejercito objetivo){
    objetivo.recibirDisparo(1);

}

 // Como se recibe un disparo (resta 1 vida)
public void recibirDisparo(int danio) {
        vida = Math.max(vida - danio, 0); 
    }

public boolean estaVivo(){
    if (vida > 0){
        return true;
    }
    else return false;
    
}




}