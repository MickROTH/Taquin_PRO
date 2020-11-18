/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class MainGraphiqueGameController implements Initializable {

    /* 
    *Variables globales correspondant à des objets définis dans la vue (fichier .fxml)
    *Ces variables sont ajoutées à la main et portent le même nom que les fx:id dans Scene Builder
     */
 /*@FXML
    private BorderPane Fond;
    @FXML
    private Label Score; 
    @FXML
    private Label Deplacement;
    @FXML
    private Button Play;
    @FXML
    private Button Look;
    @FXML
    private Button Image;
    @FXML
    private TextField Taille;
    @FXML
    private GridPane Grille;
    @FXML
    private Menu Classement;
    @FXML
    private Menu Aide;
    @FXML
    private MenuItem Sauvegarde;
    @FXML
    private MenuItem Charge;
    @FXML
    private MenuItem Quitter;
     */
    @FXML
    private ImageView buttonPlay;
    //@FXML
    //private ImageView imageGrille;

    private boolean etatBouton;

    @FXML
    public void handleButtonAction() { //methode pour qu'au clique l'image du bouton se change  en "pause" et inversement en "play"
        if (true == etatBouton) {
            buttonPlay.setImage(new Image("images/pause.png"));
        }
        if (false == etatBouton) {
            buttonPlay.setImage(new Image("images/play.png"));
        }
        etatBouton = !etatBouton;

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        etatBouton = true;
    }
}
