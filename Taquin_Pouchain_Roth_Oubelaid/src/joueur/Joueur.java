/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joueur;

import java.io.Serializable;

/**
 * Représente un joueur, avec son pseudo en guise d'identifiant.
 * @author Mick
 */
public class Joueur implements Serializable{
   
    private String pseudo;
    
    /**
     * Constructeur : Instancie un joueur avec son pseudo
     * @param pseudo Pseudo du joueur
     * @throws IllegalArgumentException Si la chaine de caractères du pseudo est vide
     */
    public Joueur(String pseudo){
        setPseudo(pseudo);
    }

    /**
     * @return Le pseudo du joueur
     */
    public String getPseudo(){
        return this.pseudo;
    }
    
    /**
     * Modifie le pseudo du joueur après avoir vérifié qu'il n'est pas nul.
     * @param pseudo Nouveau pseudo
     * @throws IllegalArgumentException Si la chaine de caractères du pseudo est vide
     */
    public void setPseudo(String pseudo){
        if (pseudo.length() == 0){
            throw new IllegalArgumentException("Un pseudo doit être composé d'au moins un caractère.");
        }
        this.pseudo = pseudo;
    }
}
