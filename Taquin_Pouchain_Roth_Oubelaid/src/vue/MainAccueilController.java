/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import Console.JeuSoloConsole;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Perso
 */
public class MainAccueilController implements Initializable {

    /**
     * Méthode à l'initialisation de la fenètre
     *
     * @param url 
     * @param rb  
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    /**
     * 
     *
     * @param event Evenement quand la personne veut lancer une partie solo en mode graphique 
     * @throws IOException
     */
    @FXML
    private void buttAvecSoloOnClick(ActionEvent event) throws IOException {

        //Ouvrir une fenetre de préparation de nouvelle partie graphique ( parametrage de la partie) 
        Parent root = FXMLLoader.load(getClass().getResource("MainGraphiqueParametre.fxml"));

        Scene scene = new Scene(root);

        Stage paramStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        paramStage.setScene(scene);
        paramStage.show();

    }

    /**
     * 
     *
     * @param eventEvenement quand la personne veut lancer une partie solo dans interface
     * graphique ( en mode console)
     * @throws IOException
     */
    @FXML
    private void buttSansSoloOnClick(ActionEvent event) throws IOException {

        // il faut cacher la fenetre d'accueil 
        //Lancer une partie en mode graphique 
        JeuSoloConsole jeu = new JeuSoloConsole();
        String[] arg = new String[10];
        JeuSoloConsole.main(arg);

    }

    /**
     * 
     *
     * @param event Evenement quand la personne veut voir le classement des joueurs
     * @throws IOException
     */
    @FXML
    private void buttClassementOnClick(ActionEvent event) throws IOException {

        //Ouvrir la fenetre du classement des joueurs  
        Parent root = FXMLLoader.load(getClass().getResource("MainGraphiqueClassement.fxml"));

        Scene scene = new Scene(root);

        Stage paramStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        paramStage.setScene(scene);
        paramStage.show();

    }

}
