/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partie;

import grille.Grille;
import joueur.Joueur;

/**
 *
 * @author micka
 */
public interface IPartie {
    public String getType();
    public Grille getGrille();
    public Joueur[] getJoueurs();
    public void mettreEnPause();
    public void reprendre();
    public void prochainTour();
    public void estFinie();
}
