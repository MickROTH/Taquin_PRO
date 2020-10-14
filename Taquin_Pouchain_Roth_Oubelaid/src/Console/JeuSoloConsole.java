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
import partie.Partie;

/**
 *
 * @author Perso
 */
public class JeuSoloConsole extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
         System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println(" .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .-----------------.  \n" +
"| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |  \n" +
"| |  _________   | || |      __      | || |    ___       | || | _____  _____ | || |     _____    | || | ____  _____  | |  \n" +
"| | |  _   _  |  | || |     /  \\     | || |  .'   '.     | || ||_   _||_   _|| || |    |_   _|   | || ||_   \\|_   _| | |  \n" +
"| | |_/ | | \\_|  | || |    / /\\ \\    | || | /  .-.  \\    | || |  | |    | |  | || |      | |     | || |  |   \\ | |   | |  \n" +
"| |     | |      | || |   / ____ \\   | || | | |   | |    | || |  | '    ' |  | || |      | |     | || |  | |\\ \\| |   | |  \n" +
"| |    _| |_     | || | _/ /    \\ \\_ | || | \\  `-'  \\_   | || |   \\ `--' /   | || |     _| |_    | || | _| |_\\   |_  | |  \n" +
"| |   |_____|    | || ||____|  |____|| || |  `.___.\\__|  | || |    `.__.'    | || |    |_____|   | || ||_____|\\____| | |  \n" +
"| |              | || |              | || |              | || |              | || |              | || |              | |  \n" +
"| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |  \n" +
" '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'   ");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");

        //Ouverture du programme (Du jeu)
        System.out.println("Bienvenu dans Taquin ! Un jeu de puzzle 🎮 ");
        
        //création du joueur 
        System.out.println("Veuillez saisir votre pseudo \n");
        Scanner sc = new Scanner(System.in);

        //récupération du choix du joueur
        String lepseudo = sc.nextLine().toString();
        
        //Instanciation du joueur
        Joueur lejoueur = new Joueur(lepseudo);

        //initialisation temporaire en attente de la saisi utilisateur 
        int tailleGrille = -1;
        //on veut éviter que la grille soit inférieur ou égale a une case de large 
        while (tailleGrille <=  1) {
            //Faire saisir une taille de grille
            System.out.println("Quel taille de plateau souhaitez vous ? ");
            sc = new Scanner(System.in);

            //récupération du choix du joueur 
            String reponse = sc.nextLine();

            //controle de saisie 
            try {
                tailleGrille = Integer.parseInt(reponse);
                if(tailleGrille <= 1){
                    System.out.println("Attention il est pas possible de faire un taquin de taille inférieur à 1");
                }
                
            }
            //si le ligne saisie par l'utilisateur n'est pas un entier ou si l'entier est inférieur à 1  
            catch (Exception e) {
                System.out.println("Attention veuillez saisir un nombre supérieur à 0");

            }
        }
        //création de la grille 
        Grille lagrille =  new Grille (tailleGrille);
        lagrille.melangeGrille(tailleGrille * 10);
        
  
        
        //Création de la partie 
        Partie lapartie = new Partie ("SOLO", lagrille, lejoueur);
        System.out.println(lapartie.getGrille().toString());


    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
