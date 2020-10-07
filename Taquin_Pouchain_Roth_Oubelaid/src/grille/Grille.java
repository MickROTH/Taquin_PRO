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
     * @param estObjectif qui nous dit si la grille est une grille objectif ou une grille de jeu 
     * La grille objectif est ranger dans l'ordre 
     * La grille non objectif est dans le désodre comme au démarage d'une partie 
     */
    public void Grille(int uneTaille, boolean estObjectif){
        this.grilleCase =  new Case[uneTaille][uneTaille];
        int compteur =0; 
        //valuer les case de 0 à  taille*taille-1
         for (int i = 0; i < this.grilleCase.length; i++) {
            for (int j = 0; j < this.grilleCase[i].length; j++) {
                this.grilleCase[i][j].setValue(compteur);
                compteur ++ ; 
            }
        }
         
        // si le tableau est pas tableau objectif il est pas mélanger 
        if (!estObjectif) {
            //on fait 1000 permutation des éléments 
            for (int i = 0; i < 1000; i++) {
                Case temp = new Case();
                int random1 = 0 + (int)(Math.random() * ((this.grilleCase.length - 0) + 1));
                int random2 = 0 + (int)(Math.random() * ((this.grilleCase.length - 0) + 1));
                int random3 = 0 + (int)(Math.random() * ((this.grilleCase.length - 0) + 1));
                int random4 = 0 + (int)(Math.random() * ((this.grilleCase.length - 0) + 1));
                temp = this.grilleCase[random1][random2] ;
                this.grilleCase[random1][random2].setValue(this.grilleCase[random3][random4].getValue()); 
                this.grilleCase[random3][random4].setValue(temp.getValue()) ;                
            }
        }
        this.taille =  uneTaille; 
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
                text += " " + this.grilleCase[i][j].getValue() + " |";
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
    public boolean estPareil(Grille autreGrille){
        boolean bool= true ;
        for (int i = 0; i < this.grilleCase.length; i++) {
            for (int j = 0; j < this.grilleCase[i].length; j++) {
                if (this.grilleCase[i][j].getValue() != autreGrille.grilleCase[i][j].getValue()) {
                    bool = false ; 
                }
            }
        }
        return bool;
    }


    
    
}
