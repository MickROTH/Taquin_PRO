/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grille;

import java.io.Serializable;

/**
 *
 * @author Perso
 */
public class Case implements Serializable {
    //Attributs de la classe 
    private int valeur; 
    int x;
    int y; 


    /**
     * Constructeur vide de la classe Case
     */
    public Case(){
        
    }
    
    /**
     * Constructeur le plus utilisé de la case 
     * @param value la valeur chiffre et visible de la case 
     * @param cooX la coordonnée en X (lignes) 
     * @param cooY la coordonnée en Y (colonnes)
     */
    public Case(int value, int cooX, int cooY){
        this.valeur = value; 
        this.x = cooX; 
        this.y = cooY; 
    }
    
    /**
     * Constructeur qui passe en paramètre une case 
     * @param c est la case modele 
     */
    public Case(Case c) {
        this.valeur = c.valeur; 
        this.x = c.x; 
        this.y = c.y; 
    }
    
    
    /**
     * permet de récupérer la valeur de la case 
     * @return  retourne la valeur de la case 
     */
    public int getValue(){
        return this.valeur;
    }
    
    /**
     * permet de modifier la valeur de la case
     * @param uneVal modifier la valeur de la case 
     */

    void setValue(int uneVal ){
        this.valeur =  uneVal;
    }
    
     /**
     * permet de permuter les coordonnée de deux cases
     * @param autreCase est la case qu'il faut permuter avec la case courante 
     */
    void permuteCoo(Case autreCase ){
        Case temp = new Case();
        temp.x =  this.x;
        temp.y =  this.y ; 
        this.x =  autreCase.x ; 
        this.y =  autreCase.y; 
        autreCase.x = temp.x; 
        autreCase.y =  temp.y;
    }

    /**
     * Afficher la valeur de la case 
     * @return  retourne les infrmation essentielle en format texte 
     */
   @Override
   public String toString(){
       return (String.valueOf(this.valeur)); 
   }
    
    
}
