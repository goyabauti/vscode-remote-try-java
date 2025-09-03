package com.mycompany.app;

public class Zombie extends Ejercito {

    public Zombie(){
        super (1);

    }

    public Zombie(float vida){

        super(vida);

    }

    @Override
    public boolean estaVivo(){
        return true;
    }



}
