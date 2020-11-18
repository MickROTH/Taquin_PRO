/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import bdd.ConnexionBDD;
import java.io.IOException;
import java.net.URL;
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
import partie.SavePartie;

/**
 * FXML Controller class
 *
 * @author Perso
 */
public class MainGraphiqueClassementController implements Initializable {

    /**
     * Récupérations des éléments FXML ici le tableau et les colonnes de ce
     * tableau
     */
    @FXML
    TableView tabClassement;

    @FXML
    TableColumn joueur1, joueur2, tailleGrille_TypePartie, temps, nbDeplacement, vainqueur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //variables pour la base de données 
        String serverName = "mysql-projettaquin.alwaysdata.net";//ou en local : "localhost";
        String port = "3306";
        String mydatabase = "projettaquin_bdd";
        String username = "214750";//utilisateur à créer dans la base
        String password = "AdminT@quin2020";//mot de passe de l'utilisateur

        // Connection à la base de donnée
        ConnexionBDD c = new ConnexionBDD(serverName, port, mydatabase, username, password);

        //Appelle à la base de donnée avec une requête select et récupération des tuples
        ArrayList<String> list = c.getTuples("SELECT * FROM Partie order by time desc");
        ArrayList<SavePartie> uneliste = new ArrayList();

        //Préparation des colonnes à receuillir les informations necessaires de la Classe SavePartie
        joueur1.setCellValueFactory(new PropertyValueFactory<>("j1"));
        joueur2.setCellValueFactory(new PropertyValueFactory<>("j2"));
        tailleGrille_TypePartie.setCellValueFactory(new PropertyValueFactory<>("typePartie_tailleGrille"));
        temps.setCellValueFactory(new PropertyValueFactory<>("time"));
        nbDeplacement.setCellValueFactory(new PropertyValueFactory<>("score"));
        vainqueur.setCellValueFactory(new PropertyValueFactory<>("gagnant"));

        // pour chaque élément récupérer de la requête 
        for (String elem : list) {
            //récupération des éléments par tronquage de la chaine de caractère
            String element = elem;
            //index
            String index = element.substring(0, element.indexOf(';'));
            element = element.substring(element.indexOf(';') + 1);
            //joueur1
            String joueure1 = element.substring(0, element.indexOf(';'));
            element = element.substring(element.indexOf(';') + 1);
            //joueur 2
            String joueure2 = element.substring(0, element.indexOf(';'));
            element = element.substring(element.indexOf(';') + 1);
            //type de partie 
            String typePartie = element.substring(0, element.indexOf(';'));
            element = element.substring(element.indexOf(';') + 1);
            // gagnant
            String gagnant = element.substring(0, element.indexOf(';'));
            element = element.substring(element.indexOf(';') + 1);
            //temps de partie
            String tempss = element.substring(0, element.indexOf(';'));
            element = element.substring(element.indexOf(';') + 1);
            //le score de partie 
            String score = element.substring(0, element.indexOf(';'));
            element = element.substring(element.indexOf(';') + 1);
            //taille de la grille
            String tailleGrille = element.substring(0, element.indexOf(';'));

            //création d'une sauvegarde
            SavePartie sauvegarde = new SavePartie(joueure1, joueure2, (typePartie + '\n' + tailleGrille + "X" + tailleGrille), gagnant, tempss, score);

            //ajouter la sauvegarde à la liste  
            uneliste.add(sauvegarde);

            //System.out.println(index + " \n le joueur : "+ joueure1 + " \n le joueur : "+ joueure2  + " \n le type de partie : "+ typePartie  + " \n le gagnant : "+ gagnant +" \n le temps : "+ temps +" \n le score : "+ score + "\n le reste : " +  element );
        }
        //conversion de la liste pour l'utiliser sur le tableau
        ObservableList<SavePartie> laListe = FXCollections.observableArrayList(uneliste);
        //ajouter les éléments dans le tableau
        tabClassement.setItems(laListe);
    }

    /**
     * Quand l'utilisateur appuie sur le bouton retour
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void ButtRetourOnClick(ActionEvent event) throws IOException {
        //Réouvrir la fenètre d'accueil 
        Parent root = FXMLLoader.load(getClass().getResource("MainAccueil.fxml"));
        Scene scene = new Scene(root);
        Stage paramStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        paramStage.setScene(scene);
        paramStage.show();
    }
}
