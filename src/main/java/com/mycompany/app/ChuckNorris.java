package com.mycompany.app;

public class ChuckNorris extends Ejercito  {

    public ChuckNorris(){
        super (1.0f);
    }

    public ChuckNorris(float vida){
     super(vida);
   
    }

    @Override
    public boolean estaVivo(){
        return true;
    }


}
