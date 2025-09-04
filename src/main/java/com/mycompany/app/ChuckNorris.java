package com.mycompany.app;

public class ChuckNorris extends Ejercito  {

    public ChuckNorris(){
        super(Float.MAX_VALUE);
    }

    public ChuckNorris(float vida){
     super(vida);
   
    }

    public void danioSupremo(Ejercito objetivo){
        objetivo.recibirDisparo(Float.MAX_VALUE);


    }    


}
