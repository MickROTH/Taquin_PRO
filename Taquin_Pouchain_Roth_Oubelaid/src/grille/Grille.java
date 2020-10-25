/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grille;

import java.io.Serializable;
import partie.Direction;

/**
 *
 * @author Perso
 */
public class Grille implements Serializable {
    //Attributs de la classe
    private Case[][] grilleCase ;
    private String image ;
    private int taille;

   
    

    /**
     * constructeur de la classe 
     * @param uneTaille la taille hauteur et largeur de la grille 
     */
     public Grille(int uneTaille){

        
             if (uneTaille > 2) {
               this.grilleCase =  new Case[uneTaille][uneTaille];

        int compteur =0; 
        //valuer les case de 0 à  taille*taille-1
         for (int i = 0; i < this.grilleCase.length; i++) {
            for (int j = 0; j < this.grilleCase[i].length; j++) {
                
                this.grilleCase[i][j] = new Case(compteur, i, j);
                compteur ++ ; 
            }
        }
        this.taille =  uneTaille; 
         }
         else{
            throw new IllegalArgumentException("La grille ne peut pas être de taille inférieur ou égale à 2.");
         }
         
         
    }
    
    
    /**
     * Permet de récuperer la grille 
     * @return 
     */
    public Case[][] getGrille(){
        return grilleCase;
    }

  
    
    
    /**
     * Permet de modifier l'image de la grille 
     * @param chemin 
     */
    public void setImage(String chemin){
        this.image = chemin; 
    }
    
    
    /**
     * Affichage de la grille sous la forme 
     * [ 0 | 1 | 2 |
     *  3 | 4 | 5 |
     *  6 | 7 | 8]
     * @return 
     */
    @Override
    public String toString(){
        String text ="";
        for (int i = 0; i < this.grilleCase.length; i++) {
            text +="[";
            for (int j = 0; j < this.grilleCase[i].length; j++) {
                if (this.grilleCase[i][j].getValue()== (this.taille * this.taille)-1) {
                      text += " " + "--" + " |";
                }
                else if (this.grilleCase[i][j].getValue()<10) {
                    text += "  " + this.grilleCase[i][j].getValue() + " |";
                }
                else{
                     text += " " + this.grilleCase[i][j].getValue() + " |";
                }
               
            }
            text +="]" + '\n';
        }
       
        return text; 
    }
    
    /**
     * cette méthode servira principalement a comparer si la grille courante, à la grille objectif ( voir si la partie est fini)
     * @param autreGrille
     * @return 
     */

    @Override
    public boolean equals(Object autreGrille) {
        boolean bool ; 
        if (autreGrille instanceof Grille) {
            Grille autreGrille2 =(Grille) autreGrille ;
            bool = true;
            for (int i = 0; i < this.grilleCase.length; i++) {
                for (int j = 0; j < this.grilleCase[i].length; j++) {
                    
                    if (this.grilleCase[i][j].getValue() != autreGrille2.getGrille()[i][j].getValue()) {
                        bool = false;
                    }
                }
            }
        } else {
            bool = false;
        }
        return bool;
    }

    /**
     * Permet de permuter deux cases aléatoirement dans un tableau
     * pas de paramètre
     */
    public void permuteCaseAdjacent() {
        Case temp = new Case();

        //avoir des coordonnées aléatoires
        int random1 = 0 + (int) (Math.random() * ((this.grilleCase.length - 2) + 1));
        int random2 = 0 + (int) (Math.random() * ((this.grilleCase.length - 2) + 1));
        
        //1 pile ou face pour savoir si la permutation ce fait horizontalement ou verticalement 
        int random3 = 0 + (int) (Math.random() * ((1 - 1) + 1));
        
        //permutation verticale
        if(random3 ==0){
              try {
            //permuter les coordonnées
            this.grilleCase[random1][random2].permuteCoo(this.grilleCase[random1 + 1][random2]);

            //permutation 
            temp = this.grilleCase[random1][random2];
            this.grilleCase[random1][random2] = this.grilleCase[random1 + 1][random2];
            this.grilleCase[random1 + 1][random2] = temp;
        } catch (Exception e) {
            //permuter les coordonnées
            this.grilleCase[random1][random2].permuteCoo(this.grilleCase[random1 - 1][random2]);

            //permutation 
            temp = this.grilleCase[random1][random2];
            this.grilleCase[random1][random2] = this.grilleCase[random1 - 1][random2];
            this.grilleCase[random1 - 1][random2] = temp;
        }
 
        }
        //permutation horizontale 
        else{
              try {
            //permuter les coordonnées
            this.grilleCase[random1][random2].permuteCoo(this.grilleCase[random1][random2+1]);

            //permutation 
            temp = this.grilleCase[random1][random2];
            this.grilleCase[random1][random2] = this.grilleCase[random1][random2+1];
            this.grilleCase[random1][random2+1] = temp;
        } catch (Exception e) {
            //permuter les coordonnées
            this.grilleCase[random1][random2].permuteCoo(this.grilleCase[random1][random2-1]);

            //permutation 
            temp = this.grilleCase[random1][random2];
            this.grilleCase[random1][random2] = this.grilleCase[random1][random2-1];
            this.grilleCase[random1][random2-1] = temp;
        }
        }
     
    }

    /**
     * Permet de permuter deux cases dans un tableau on passe en parametre les
     * deux cases à permuter
     */
    public void permuteCase(Case c1, Case c2) {
        try {
            Case temp = new Case(c1);

            //permuter les coordonnées
            c1.permuteCoo(c2);

            //permutation 
            temp = this.grilleCase[c1.x][c1.y];
            this.grilleCase[c1.x][c1.y] = this.grilleCase[c2.x][c2.y];
            this.grilleCase[c2.x][c2.y] = temp;
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * melanger la grille on passe un int qui definit le nombre de permutation
     * que l'on souhaite effectuer
     */
    public void melangeGrille(int nbpermut){
        if (nbpermut % 2  == 0) {
            for (int i = 0; i < nbpermut; i++) {
            permuteCaseAdjacent();
            }
        }
        else  {
            for (int i = 1; i < nbpermut; i++) {
            permuteCaseAdjacent();
            }
        }
        
    }
    
   
    
    
    /**
     * Permet de bouger une case 
     * on passe en paramètre une direction 
     * 
     */
    public void bougeCase(Direction direction){
        
        Case caseVide = new Case (this.laCaseVide());
        //System.out.println(caseVide.toString());
       
        
        //Test sur le type de mouvement 
        switch (direction){
            
            //La case à gauche du vide vas vers la droite 
            case DROITE :
                if (caseVide.y-1>=0) {
                    permuteCase(this.grilleCase[caseVide.x][caseVide.y],this.grilleCase[caseVide.x][caseVide.y-1]);
                }
                else{
                   throw new IllegalArgumentException("Il n'y a pas de case à déplacer vers la droite.."); 
                }
                break;
                
                //la case à droite du vide vas vers la gauche 
            case GAUCHE :
                 if (caseVide.y+1<=this.taille-1) {
                    permuteCase(this.grilleCase[caseVide.x][caseVide.y],this.grilleCase[caseVide.x][caseVide.y+1]);
                }
                else{
                   throw new IllegalArgumentException("Il n'y a pas de case a déplacer vers la gauche.."); 
                }
                break;
                
                //La case en bas du vide doit monter
            case HAUT :
                  if (caseVide.x+1 <= taille -1) {
                    permuteCase(this.grilleCase[caseVide.x][caseVide.y],this.grilleCase[caseVide.x+1][caseVide.y]);
                }
                else{
                   throw new IllegalArgumentException("Il n'y a pas de case a déplacer vers le haut.."); 
                }
                break;
                
                //La case en haut du vide doit descendre 
            case BAS  :
                 if (caseVide.x-1>=0) {
                    permuteCase(this.grilleCase[caseVide.x][caseVide.y],this.grilleCase[caseVide.x-1][caseVide.y]);
                }
                else{
                   throw new IllegalArgumentException("Il n'y a pas de case a déplacer vers le bas.."); 
                }
                break;
                
                // si le deplacement est pas définit
            case NONE :  
                throw new IllegalArgumentException("Erreur"); 
        } 
        
    }
 
    /**
     * laCaseVide
     * revois la case vide du tableau 
     */
    public Case laCaseVide(){
        Case laCase = new Case();
        //on explore le tableau 
        for (int i = 0; i < this.grilleCase.length; i++) {
            for (int j = 0; j <this.grilleCase.length; j++) {
                //Si c'est la case vide 
                if (this.grilleCase[i][j].getValue()== (this.taille*this.taille)-1){
                    laCase =  this.grilleCase[i][j];
                }
            }
        }
        return laCase;
    }
    
}
