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
    //Attributs de la classe 
    private int valeur; 
    int x;
    int y; 
    
    /**
     * Constructeur vide de la classe Case
     */
    public void Case(){
        
    }
    
    /**
     * Constructeur le plus utilisé de la case 
     * @param value la valeur chiffre et visible de la case 
     * @param cooX la coordonnée en X (lignes) 
     * @param cooY la coordonnée en Y (colonnes)
     */
    public void Case(int value, int cooX, int cooY){
        this.valeur = value; 
        this.x = cooX; 
        this.y = cooY; 
    }
    
    /**
     * permet de récupérer la valeur de la case 
     * @return 
     */
    public int getValue(){
        return this.valeur;
    }
    
    /**
     * permet de modifier la valeur de la case
     * @param uneVal 
     */
    public void setValue(int uneVal ){
        this.valeur =  uneVal;
    }
    
    /**
     * Afficher la valeur de la case 
     * @return 
     */
   @Override
   public String toString(){
       return (String.valueOf(this.valeur)); 
   }
    
    
}
