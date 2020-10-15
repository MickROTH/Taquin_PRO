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

        //variable de controle de saisie 
        boolean estValide= false ;
        //Le pseudo
        String lePseudo =""; 
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
        
        
        //Ouverture du programme (Du jeu)
        System.out.println("Bienvenu dans Taquin ! Un jeu de puzzle 🎮 ");
        

        //on veut éviter que le pseudo soit null ou sans caractère
        while (!estValide) {
        //création du joueur 
        System.out.println("Veuillez saisir votre pseudo \n");
         sc = new Scanner(System.in);

        //récupération du choix du joueur
        lePseudo = sc.nextLine().toString();
        
            try{
                // test Instanciation du joueur
                leJoueur = new Joueur(lePseudo);
                
                //validation du format
                estValide= true ;
            }
            catch(Exception e){
                   //création du joueur 
            System.out.println(e.getMessage());
            }
        }

        //Instanciation du joueur
        leJoueur = new Joueur(lePseudo);

        //controle de saisie 
        estValide = false ;
        //on veut éviter que la grille soit inférieur ou égale a une case de large 
        while (!estValide) {
          
            //Faire saisir une taille de grille
            System.out.println("Quel taille de plateau souhaitez vous ? ");
            sc = new Scanner(System.in);

            //récupération du choix du joueur 
            String reponse = sc.nextLine();

            //controle de saisie 
            try {

                try{
                     tailleGrille = Integer.parseInt(reponse);
                }
                catch(Exception e ){
                    System.out.println("Erreur il faut saisir un nombre.");
                }
               
                //test création de la grille 
                laGrille =  new Grille (tailleGrille);
               
                //validation du format 
                estValide = true ; 
            }
            //si le ligne saisie par l'utilisateur n'est pas un entier ou si l'entier est inférieur à 1  
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
        
        //System.out.println(laPartie.getGrille().toString());
        //System.out.println(grilleObjectif.toString());
       
        //Condition de fin de partie 
        while(!laPartie.getGrille().equals(grilleObjectif)){
            /*
            
            Tout le traitement du jeu 
            
            */
        }
        if (laPartie.getGrille().equals(grilleObjectif)){
            System.out.println("Vous avez gagner la partie ! ");
        }
        

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
