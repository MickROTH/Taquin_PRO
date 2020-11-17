/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import Console.JeuSoloConsole;
import bdd.ConnexionBDD;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Perso
 */
public class MainAccueilController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }  
    

    @FXML
    ImageView imageFond;

    @FXML
    private void buttAvecSoloOnClick(ActionEvent event) throws IOException {

        //Ouvrir un autre fenetre graphisue 
        Parent root = FXMLLoader.load(getClass().getResource("MainGraphiqueParametre.fxml"));

        Scene scene = new Scene(root);

        Stage paramStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        paramStage.setScene(scene);
        paramStage.show();

    }

    @FXML
    private void buttSansSoloOnClick(ActionEvent event) throws IOException {
        System.out.println("Oh on a cliquer sur moi !");

        // il faut cacher la fenetre d'accueil 
        JeuSoloConsole jeu = new JeuSoloConsole();
        String[] arg = new String[10];
        JeuSoloConsole.main(arg);

    }
@FXML
    private void buttClassementOnClick(ActionEvent event) throws IOException {

       //Ouvrir un autre fenetre graphisue 
        Parent root = FXMLLoader.load(getClass().getResource("MainGraphiqueClassement.fxml"));

        Scene scene = new Scene(root);

        Stage paramStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        paramStage.setScene(scene);
        paramStage.show();

    }
   
    
    
}
