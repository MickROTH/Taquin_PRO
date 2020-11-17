/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import bdd.ConnexionBDD;
import grille.Grille;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import joueur.Joueur;
import partie.Partie;
import partie.SavePartie;
import static partie.TypePartie.SOLO;

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

        ArrayList<String> list = c.getTuples("SELECT * FROM Partie order by time desc" );
        ArrayList<SavePartie> uneliste = new ArrayList() ;

        
       
      joueur1.setCellValueFactory(new PropertyValueFactory<>("j1"));
      joueur2.setCellValueFactory(new PropertyValueFactory<>("j2"));
      tailleGrille_TypePartie.setCellValueFactory(new PropertyValueFactory<>("typePartie_tailleGrille"));
      temps.setCellValueFactory(new PropertyValueFactory<>("time"));
      nbDeplacement.setCellValueFactory(new PropertyValueFactory<>("score"));
      vainqueur.setCellValueFactory(new PropertyValueFactory<>("gagnant"));
       
      
         // Affichage à l'aide d'une boucle forEach
       for(String elem: list)
       {
          String element = elem;
          String index = element.substring(0, element.indexOf( ';'));
          element = element.substring(element.indexOf(';')+1);
          String joueure1 = element.substring(0, element.indexOf( ';'));
          element = element.substring(element.indexOf(';')+1);
          String joueure2 = element.substring(0, element.indexOf( ';'));
          element = element.substring(element.indexOf(';')+1);
          String typePartie = element.substring(0, element.indexOf( ';'));
          element = element.substring(element.indexOf(';')+1);
          String gagnant = element.substring(0, element.indexOf( ';'));
          element = element.substring(element.indexOf(';')+1);
          String tempss = element.substring(0, element.indexOf( ';'));
          element = element.substring(element.indexOf(';')+1);
          String score = element.substring(0, element.indexOf( ';'));
          element = element.substring(element.indexOf(';')+1);
          String tailleGrille = element.substring(0, element.indexOf( ';'));
          
         

      
               //création d'une sauvegarde
             SavePartie sauvegarde =  new SavePartie( joueure1,joueure2,  (typePartie + '\n'+tailleGrille+"X"+tailleGrille),  gagnant,  tempss,  score);
          
              uneliste.add(sauvegarde);

          
          System.out.println(index + " \n le joueur : "+ joueure1 + " \n le joueur : "+ joueur2  + " \n le type de partie : "+ typePartie  + " \n le gagnant : "+ gagnant +" \n le temps : "+ temps +" \n le score : "+ score + "\n le reste : " +  element );
        
       }
      
      ObservableList<SavePartie> laListe = FXCollections.observableArrayList(uneliste);
        tabClassement.setItems(laListe);
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
