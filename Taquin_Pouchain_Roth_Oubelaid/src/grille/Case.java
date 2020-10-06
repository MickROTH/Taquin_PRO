/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grille;

/**
 *
 * @author Perso
 */
public class Case {
    private int valeur; 
    int x;
    int y; 
    

    public void Case(){
        
    }
    

    public void Case(int value, int cooX, int cooY){
        this.valeur = value; 
        this.x = cooX; 
        this.y = cooY; 
    }
    
    public int getValue(){
        return this.valeur;
    }
    

    public void setValue(int uneVal ){
        this.valeur =  uneVal;
    }
    

   @Override
   public String toString(){
       return (String.valueOf(this.valeur)); 
   }
    
    
}
