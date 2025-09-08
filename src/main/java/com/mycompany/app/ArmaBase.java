package com.mycompany.app;

public abstract class ArmaBase{
  //atributos

  private float danioBase;
  private int municion;

  protected ArmaBase(float danioBase, int municion){
  this.danioBase = danioBase;
  this.municion = municion;
  }

  public float usar(){
    if (municion <= 0) return 0.0f;
    municion--;
    return danioBase;

  }

  public int getMunicion(){
     return municion; 
  } 
  


}