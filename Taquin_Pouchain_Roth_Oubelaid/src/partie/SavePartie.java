/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partie;

/**
 *
 * @author Perso
 */
public class SavePartie {

    /**
     * Les paramètres de la Classe
     */
    private String j1;
    private String j2;
    private String typePartie_tailleGrille;
    private String gagnant;
    private String time;
    private String score;

    /**
     * Le constructeur de la classe sauvegarde des données de partie si la
     * partie est solo alors j2 est null
     *
     * @param j1 correspond au joueur numéro 1
     * @param j2 correspond au joueur numéro 2
     * @param typePartie_tailleGrille parametre qui représente la taille de la grille et le type de partie 
     * @param gagnant correspond au nom du joueur gagnant 
     * @param time correspond au temps écouler de la partie 
     * @param score est le score de deplacement de cases 
     */
    public SavePartie(String j1, String j2, String typePartie_tailleGrille, String gagnant, String time, String score) {
        this.j1 = j1;
        this.j2 = j2;
        this.typePartie_tailleGrille = typePartie_tailleGrille;
        this.gagnant = gagnant;
        this.time = time;
        this.score = score;
    }

    /**
     * Getteur du joueur 1
     *
     * @return String
     */
    public String getJ1() {
        return j1;
    }

    /**
     * Getteur du joueur 2
     *
     * @return String
     */
    public String getJ2() {
        return j2;
    }

    /**
     * Getteur de la taille de la grille et du type de partie
     *
     * @return String
     */
    public String getTypePartie_tailleGrille() {
        return typePartie_tailleGrille;
    }

    /**
     * Getteur du gagnant
     *
     * @return String
     */
    public String getGagnant() {
        return gagnant;
    }

    /**
     * Getteur du temps de partie
     *
     * @return String
     */
    public String getTime() {
        return time;
    }

    /**
     * Getteur du score
     *
     * @return String
     */
    public String getScore() {
        return score;
    }

    public String getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
