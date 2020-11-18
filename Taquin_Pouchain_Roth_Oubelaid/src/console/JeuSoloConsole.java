/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;

import bdd.ConnexionBDD;
import bdd.SerialisationPartie;
import grille.Grille;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
import utilities.Chrono;

/**
 *
 * @author Perso
 */
public class JeuSoloConsole extends Application {

    @Override
    public void start(Stage primaryStage) {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
        //variables pour la base de données 
        Connection con = null;
        ResultSet rs;
        String serverName = "mysql-projettaquin.alwaysdata.net";//ou en local : "localhost";
        String port = "3306";
        String mydatabase = "projettaquin_bdd";
        String connectUrl = "jdbc:mysql://" + serverName + ":" + port + "/" + mydatabase; // a JDBC url
        String username = "214750";//utilisateur à créer dans la base
        String password = "AdminT@quin2020";//mot de passe de l'utilisateur
        String query;
        //compteur de deplacement 
        int nbDeplacement = 0;
        //chronometre 
        Chrono chrono = new Chrono();
        chrono.start(); // démarrage du chrono

        //Ouverture du programme (Du jeu)
        System.out.println("Bienvenu dans Taquin ! Un jeu de puzzle 🎮 pour quitter le jeu écrivez 'end' ou 'quitter' ");

        //on veut éviter que le pseudo soit null ou sans caractère
        while (!estValide) {
            //création du joueur 
            System.out.println("Veuillez saisir votre pseudo ");
            sc = new Scanner(System.in);

            //récupération du choix du joueur
            lePseudo = sc.nextLine().toString();

            //si la personne veut quitter la partie
            if (lePseudo.equalsIgnoreCase("end") || lePseudo.equalsIgnoreCase("quitter")) {
                System.out.println("Vous aller quitter le jeu ");
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
            System.out.println("Quel taille de plateau souhaitez vous ? Pour quitter le jeu écrivez 'end' ou 'quitter' ");
            sc = new Scanner(System.in);

            //récupération du choix du joueur 
            String reponse = sc.nextLine();

            //si la personne veut quitter la partie
            if (reponse.equalsIgnoreCase("end") || reponse.equalsIgnoreCase("quitter")) {
                System.out.println("Vous aller quitter le jeu ");
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
            } //si le ligne saisie par l'utilisateur n'est pas un entier ou si l'entier est inférieur à 2
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        //création de la grille 
        laGrille = new Grille(tailleGrille);
        grilleObjectif = new Grille(tailleGrille);
        laGrille.melangeGrille(tailleGrille * tailleGrille);

        //Création de la partie 
        Partie laPartie = new Partie(SOLO, laGrille, leJoueur);

        //Condition de fin de partie 
        while (!laPartie.getGrille().equals(grilleObjectif)) {
            //Afficher le plateau a chaque tours 
            System.out.println(laPartie.getGrille().toString());

            //proposer au joueur de déplacer la case 
            System.out.println("Quel case voulez vous déplacer ? 'q' pour la gauche, 'z' pour haut, 'd' pour droite et 's' pour bas. \n Pour quitter le jeu écrivez 'end' ou 'quitter' ");
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
                if (laDirection.equalsIgnoreCase("end") || laDirection.equalsIgnoreCase("quitter")) {
                    System.out.println("Vous aller quitter le jeu ");

                    //sérialisation de la partie 
                    SerialisationPartie partie = new SerialisationPartie();
                    partie.serialise(laPartie);

                    //partie.deserialise();
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
                } finally {
                    // on comptabilise le deplacement même si la personne a tenter au faux mouvement 
                    nbDeplacement++;
                }
            }
        }
        //on vérifie que la partie est bien terminé 
        if (laPartie.getGrille().equals(grilleObjectif)) {
            System.out.println("Vous avez gagner la partie ! ");
            System.out.println("La partie vas être sauvegarder dans le classement, entrez 'end' pour quitter le jeu, entrez 'home' pour revenir a l'acceuil ");
            sc = new Scanner(System.in);

            // récupération de la date du jour 
            //Date aujourdhui = ;
            DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date aujourdhui = new Date();

            //on arrete le chrono
            chrono.stop();
            //System.out.println(chrono.getDureeTxt());
            try {
                //connexion à la base de données
                ConnexionBDD c = new ConnexionBDD(serverName, port, mydatabase, username, password);
                //Nouvelle partie 
                //INSERT INTO Partie (J1, J2, typePartie,Gagnant, time , score, tailleGrille, datePartie ) VALUES ('patate' , null, 'SOLO', 'patate', "00:20:30", 10,3, "20/10/2020")
                query = "INSERT INTO Partie (J1, J2, typePartie,Gagnant, time , score, tailleGrille, datePartie ) VALUES ('" + lePseudo + "' , null, 'SOLO', '" + lePseudo + "', '" + chrono.getDureeTxt() + "', " + nbDeplacement + ", "+ laGrille.getGrille().length + ", '"  + aujourdhui + "')";
                //System.out.println(query);
                c.insertTuples(query);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            //récupération du choix du joueur
            String reponse = sc.nextLine().toString();

            while (!(reponse.equals("end") || reponse.equals("quitter") || reponse.equals("home") || reponse.equals("accueil"))) {
                System.out.println("entrez 'end' pour quitter le jeu, entrez 'home' ou 'acceuil' pour revenir a l'acceuil");
                //récupération du choix du joueur
                reponse = sc.nextLine().toString();
            } if(reponse.equals("end") || reponse.equals("quitter") || reponse.equals("home") || reponse.equals("accueil"))  {
                if (reponse.equalsIgnoreCase("end") || reponse.equalsIgnoreCase("quitter")) {
                    System.out.println("Vous aller quitter le jeu ");

                    //Fermer le jeu
                    System.exit(1);
                } else if (reponse.equalsIgnoreCase("home") || reponse.equalsIgnoreCase("accueil")) {
                    System.out.println("Vous aller retourner à l'acceuil");
                    /*
                         retour à l'acceuil 
                         
                     */

                }

            }

        }
        launch(args);

    }

}
