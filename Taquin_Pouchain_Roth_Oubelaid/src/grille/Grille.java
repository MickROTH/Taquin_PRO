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
public class Grille {
    private Case[][] grilleCase ;
    private String image ;
    private int taille;
    
    public void Grille(int uneTaille){
        this.taille =  uneTaille; 
    }
    
    public Case[][] getGrille(){
        return grilleCase;
    }
    
    public void setImage(String chemin){
        this.image = chemin; 
    }
    
    @Override
    public String toString(){
        String text ="[";
        for (int i = 0; i < this.grilleCase.length; i++) {
            for (int j = 0; j < this.grilleCase[i].length; j++) {
                text += " " + this.grilleCase[i][j].getValue() + " |";
            }
            text += '\n';
        }
        text += "]";
        return text; 
    }
    

    
    
}
