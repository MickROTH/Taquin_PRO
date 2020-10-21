/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;

import grille.Grille;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import joueur.Joueur;
import partie.Direction;
import static partie.Direction.BAS;
import static partie.Direction.DROITE;
import static partie.Direction.GAUCHE;
import static partie.Direction.HAUT;
import static partie.Direction.NONE;
import partie.Partie;
import partie.TypePartie;
import static partie.TypePartie.SOLO;

/**
 *
 * @author Perso
 */
public class JeuSoloConsole extends Application {

    @Override
    public void start(Stage primaryStage) {

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println(" .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .-----------------.  \n"
                + "| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |  \n"
                + "| |  _________   | || |      __      | || |    ___       | || | _____  _____ | || |     _____    | || | ____  _____  | |  \n"
                + "| | |  _   _  |  | || |     /  \\     | || |  .'   '.     | || ||_   _||_   _|| || |    |_   _|   | || ||_   \\|_   _| | |  \n"
                + "| | |_/ | | \\_|  | || |    / /\\ \\    | || | /  .-.  \\    | || |  | |    | |  | || |      | |     | || |  |   \\ | |   | |  \n"
                + "| |     | |      | || |   / ____ \\   | || | | |   | |    | || |  | '    ' |  | || |      | |     | || |  | |\\ \\| |   | |  \n"
                + "| |    _| |_     | || | _/ /    \\ \\_ | || | \\  `-'  \\_   | || |   \\ `--' /   | || |     _| |_    | || | _| |_\\   |_  | |  \n"
                + "| |   |_____|    | || ||____|  |____|| || |  `.___.\\__|  | || |    `.__.'    | || |    |_____|   | || ||_____|\\____| | |  \n"
                + "| |              | || |              | || |              | || |              | || |              | || |              | |  \n"
                + "| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |  \n"
                + " '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'   ");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");

        //variable de controle de saisie 
        boolean estValide = false;
        //Le pseudo
        String lePseudo = "";
        //Le joueur
        Joueur leJoueur;
        //Permet de récupéré les données saisie par l'utilisateur 
        Scanner sc;
        //Taille de la grille
        int tailleGrille = 0;
        //La grille 
        Grille laGrille;
        //La grille objectif
        Grille grilleObjectif;
        //direction que doit effectuer la case  
        String laDirection = "";

        //Ouverture du programme (Du jeu)
        System.out.println("Bienvenu dans Taquin ! Un jeu de puzzle 🎮 pour quitter le jeu écrivez 'end' ");

        //on veut éviter que le pseudo soit null ou sans caractère
        while (!estValide) {
            //création du joueur 
            System.out.println("Veuillez saisir votre pseudo \n");
            sc = new Scanner(System.in);

            //récupération du choix du joueur
            lePseudo = sc.nextLine().toString();

            //si la personne veut quitter la partie
            if (lePseudo.equalsIgnoreCase("end")) {
                System.out.println("Vous aller quitter le jeu ");
                /*
                    Sauvegarde des donnees en local 
                    Sauvegarde si possible des données à distances 
                    fermer le jeu
                 */
                //Fermer le jeu
                System.exit(1);
            }

            try {
                // test Instanciation du joueur
                leJoueur = new Joueur(lePseudo);

                //validation du format
                estValide = true;
            } catch (Exception e) {
                //création du joueur 
                System.out.println(e.getMessage());
            }
        }

        //Instanciation du joueur
        leJoueur = new Joueur(lePseudo);

        //controle de saisie 
        estValide = false;
        //on veut éviter que la grille soit inférieur ou égale a une case de large 
        while (!estValide) {

            //Faire saisir une taille de grille
            System.out.println("Quel taille de plateau souhaitez vous ? ");
            sc = new Scanner(System.in);

            //récupération du choix du joueur 
            String reponse = sc.nextLine();

            //si la personne veut quitter la partie
            if (reponse.equalsIgnoreCase("end")) {
                System.out.println("Vous aller quitter le jeu ");
                /*
                    Sauvegarde des donnees en local 
                    Sauvegarde si possible des données à distances 
                    fermer le jeu
                 */
                //Fermer le jeu
                System.exit(1);
            }

            //controle de saisie 
            try {

                try {
                    tailleGrille = Integer.parseInt(reponse);
                } catch (Exception e) {
                    System.out.println("Erreur il faut saisir un nombre.");
                }

                //test création de la grille 
                laGrille = new Grille(tailleGrille);

                //validation du format 
                estValide = true;
            } //si le ligne saisie par l'utilisateur n'est pas un entier ou si l'entier est inférieur à 1  
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        //création de la grille 
        laGrille = new Grille(tailleGrille);
        grilleObjectif = new Grille(tailleGrille);
        laGrille.melangeGrille(tailleGrille * 10);

        //Création de la partie 
        Partie laPartie = new Partie(SOLO, laGrille, leJoueur);

        //Condition de fin de partie 
        while (!laPartie.getGrille().equals(grilleObjectif)) {
            //Afficher le plateau a chaque tours 
            System.out.println(laPartie.getGrille().toString());

            //proposer au joueur de déplacer la case 
            System.out.println("Quel case voulez vou déplacer ? 'q' pour la gauche, 'z' pour haut, 'd' pour droite et 's' pour bas  \n");
            sc = new Scanner(System.in);

            //récupération du choix du joueur
            laDirection = sc.nextLine().toString();
            laDirection.toLowerCase();
            Direction direction = NONE;

            //vérification du format de la saisi pour la changer en direction 
            //Si la saisie de l'utilisateur convient à ce que l'on a besoin 
            if (!(laDirection.equals("d") || laDirection.equals("droite")
                    || laDirection.equals("q") || laDirection.equals("gauche")
                    || laDirection.equals("z") || laDirection.equals("haut")
                    || laDirection.equals("s") || laDirection.equals("bas"))) {
                if (laDirection.equalsIgnoreCase("end")) {
                    System.out.println("Vous aller quitter le jeu ");
                    /*
                    Sauvegarde des donnees en local 
                    Sauvegarde si possible des données à distances 
                    
                     */
                    //Fermer le jeu
                    System.exit(1);
                } else {
                    System.out.println("Vous devez écrire d pour Droite, q pour Gauche, z pour Haut ou s pour Bas");
                }

            } else {
                //on attribut la direction a la variable de direction 
                if (laDirection.equals("d") || laDirection.equals("droite")) {
                    direction = DROITE;
                } else if (laDirection.equals("q") || laDirection.equals("gauche")) {
                    direction = GAUCHE;
                } else if (laDirection.equals("z") || laDirection.equals("haut")) {
                    direction = HAUT;
                } else if (laDirection.equals("s") || laDirection.equals("bas")) {
                    direction = BAS;
                }

                try {
                    //intervertire les deux cases ( case vide et case [direction]
                    laPartie.getGrille().bougeCase(direction);
                } catch (Exception e) {
                    //afiicher l'erreur dans le cas échéant
                    System.out.println("Probleme : " + e.getMessage());
                }
            }
        }
        //on vérifie que la partie est bien terminé 
        if (laPartie.getGrille().equals(grilleObjectif)) {
            System.out.println("Vous avez gagner la partie ! ");
            System.out.println("La partie vas être sauvegarder dans le classement, entrez 'end' pour quitter le jeu, entrez 'home' pour revenir a l'acceuil ");
            sc = new Scanner(System.in);

            /*
                    Sauvegarde des donnees en local 
                    Sauvegarde si possible des données à distances 
                    
             */
            //récupération du choix du joueur
            String reponse = sc.nextLine().toString();

            if (!(reponse.equals("end") || reponse.equals("home"))) {
                System.out.println("entrez 'end' pour quitter le jeu, entrez 'home' pour revenir a l'acceuil");
            } else {
                if (reponse.equalsIgnoreCase("end")) {
                    System.out.println("Vous aller quitter le jeu ");

                    //Fermer le jeu
                    System.exit(1);
                } else if (reponse.equalsIgnoreCase("home")) {
                    System.out.println("Vous aller retourner à l'acceuil");
                    /*
                         retour à l'acceuil 
                         
                     */

                }

            }

        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
