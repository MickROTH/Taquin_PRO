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
    //Attributs de la classe
    private Case[][] grilleCase ;
    private String image ;
    private int taille;

   
    

    /**
     * constructeur de la classe 
     * @param uneTaille la taille hauteur et largeur de la grille 
     */
     public Grille(int uneTaille){

        
             if (uneTaille > 1) {
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
            throw new IllegalArgumentException("La grille ne peut pas être de taille inférieur ou égale à 1.");
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
        String text ="[";
        for (int i = 0; i < this.grilleCase.length; i++) {
            for (int j = 0; j < this.grilleCase[i].length; j++) {
                if (this.grilleCase[i][j].getValue()== (this.taille * this.taille)-1) {
                      text += " " + "--" + " |";
                }
                else{
                     text += " " + this.grilleCase[i][j].getValue() + " |";
                }
               
            }
            text += '\n';
        }
        text += "]";
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
     */
    public void permuteCaseAlea(){
         Case temp = new Case();
         
         //avoir des coordonnées aléatoires
                int random1 = 0 + (int)(Math.random() * ((this.grilleCase.length - 1) + 1));
                int random2 = 0 + (int)(Math.random() * ((this.grilleCase.length - 1) + 1));
                int random3 = 0 + (int)(Math.random() * ((this.grilleCase.length - 1) + 1));
                int random4 = 0 + (int)(Math.random() * ((this.grilleCase.length - 1) + 1));
                
                //permuter les coordonnées
                this.grilleCase[random1][random2].permuteCoo(this.grilleCase[random3][random4]);
                
                //permutation 
                temp = this.grilleCase[random1][random2] ;
                this.grilleCase[random1][random2]= this.grilleCase[random3][random4]; 
                this.grilleCase[random3][random4]= temp ;      
    }
    
    
    /**
     * Permet de permuter deux cases dans un tableau 
     */
    public void permuteCase(Case c1 , Case c2){
        Case temp = new Case();
        
                //permuter les coordonnées
                c1.permuteCoo(c2);
                
                //permutation 
                temp = c1 ;
                c1= c2; 
                c2= temp ;    
    }
    
     /**
     * melanger la grille 
     * on passe un int qui definit le nombre de permutation que l'on souhaite effectuer 
     */
    public void melangeGrille(int nbpermut){
        for (int i = 0; i < nbpermut; i++) {
            permuteCaseAlea();
        }
    }
}
