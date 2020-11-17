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
    private String j1 ; 
    private String j2 ; 
    private String typePartie_tailleGrille; 
    private String gagnant ; 
    private String time ; 
    private String score ; 

    public SavePartie(String j1, String j2, String typePartie_tailleGrille, String gagnant, String time, String score) {
        this.j1 = j1;
        this.j2 = j2;
        this.typePartie_tailleGrille = typePartie_tailleGrille;
        this.gagnant = gagnant;
        this.time = time;
        this.score = score;
    }

    public String getJ1() {
        return j1;
    }

    public String getJ2() {
        return j2;
    }

    public String getTypePartie_tailleGrille() {
        return typePartie_tailleGrille;
    }

    public String getGagnant() {
        return gagnant;
    }

    public String getTime() {
        return time;
    }

    public String getScore() {
        return score;
    }
    
    
    
    
    
}
