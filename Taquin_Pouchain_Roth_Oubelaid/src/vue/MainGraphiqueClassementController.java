/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import bdd.ConnexionBDD;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Perso
 */
public class MainGraphiqueClassementController implements Initializable {

    @FXML
    TableView tabClassement; 
    
    @FXML
    TableColumn joueur1, joueur2, tailleGrille_TypePartie, temps, nbDeplacement, vainqueur ; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        
        ConnexionBDD c = new ConnexionBDD(serverName, port, mydatabase, username, password);

        ArrayList<String> list = c.getTuples("SELECT * FROM Partie order by time" );
        

         // Affichage à l'aide d'une boucle forEach
       for(String elem: list)
       {
          String element = elem;
          String index = element.substring(0, element.indexOf( ';'));
          element = element.substring(element.indexOf(';')+1);
          String joueur1 = element.substring(0, element.indexOf( ';'));
          element = element.substring(element.indexOf(';')+1);
          String joueur2 = element.substring(0, element.indexOf( ';'));
          element = element.substring(element.indexOf(';')+1);
          String typePartie = element.substring(0, element.indexOf( ';'));
          element = element.substring(element.indexOf(';')+1);
          String gagnant = element.substring(0, element.indexOf( ';'));
          element = element.substring(element.indexOf(';')+1);
          String temps = element.substring(0, element.indexOf( ';'));
          element = element.substring(element.indexOf(';')+1);
          String score = element.substring(0, element.indexOf( ';'));
          
          
          
          System.out.println(index + " \n le joueur : "+ joueur1 + " \n le joueur : "+ joueur2  + " \n le type de partie : "+ typePartie  + " \n le gagnant : "+ gagnant +" \n le temps : "+ temps +" \n le score : "+ score + "\n le reste : " +  element );
         //tabClassement.getItems().addAll(joueur1);
       	 //System.out.println (elem + '\n');
       }
    }    
    
    
    
     @FXML
    private void ButtRetourOnClick(ActionEvent event) throws IOException {
     //Ouvrir un autre fenetre graphisue 
        Parent root = FXMLLoader.load(getClass().getResource("MainAccueil.fxml"));

        Scene scene = new Scene(root);

        Stage paramStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        paramStage.setScene(scene);
        paramStage.show();
    }
}
