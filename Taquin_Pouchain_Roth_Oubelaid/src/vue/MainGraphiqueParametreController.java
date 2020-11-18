/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Perso
 */
public class MainGraphiqueParametreController implements Initializable {

    //variables globales 
    int laTaille;
    String lePseudo;
    String lImage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * Récupération des élément FXML ici il y a les comboBox, la choiceBox et
     * les champs de saisies
     */
    @FXML
    RadioButton ComboImage1, ComboImage2, ComboImage3, ComboImage4, ComboImage5, ComboImage6;

    @FXML
    ChoiceBox ChoiceTheme;

    @FXML
    TextField txtPseudo, txtTaille;

    /**
     * Controle de saisi avant le lancement de la partie
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void bttValidezOnClick(ActionEvent event) throws IOException {

        if (!txtPseudo.getText().isEmpty()) {
            if (!txtTaille.getText().isEmpty()) {
                try {
                    laTaille = Integer.parseInt(txtTaille.getText());
                    if (laTaille <= 2) {
                        //alert si la taille  de la grille est trop petite 
                        Alert alert = new Alert(AlertType.WARNING);
                        alert.setTitle("Attention");

                        // Header Text: null
                        alert.setHeaderText(null);
                        alert.setContentText("La taille de la grille doit être supérieur à 2");

                        alert.showAndWait();
                    } else {
                        lePseudo = txtPseudo.getText();

                        //Lancer la fenètre de jeu
                        Parent root = FXMLLoader.load(getClass().getResource("MainGraphiqueGame.fxml"));
                        Scene scene = new Scene(root);
                        Stage gameStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        gameStage.setScene(scene);
                        gameStage.show();

                    }
                } catch (Exception e) {
                    //alert si la taille saisi n'est pas un chiffre 
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Attention");

                    // Header Text: null
                    alert.setHeaderText(null);
                    alert.setContentText("Saisissez un chiffre !");

                    alert.showAndWait();
                }

            } else {
                //alert si il y a pas de taille saisi
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Attention");

                // Header Text: null
                alert.setHeaderText(null);
                alert.setContentText("Veuillez saisir une taille");

                alert.showAndWait();
            }
        } else {
            //alert si il y a pas de pseudo saisi
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Attention");

            // Header Text: null
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir un pseudo");

            alert.showAndWait();
        }

    }

    /**
     * Controle de saisi des comboBox pour que 1 seule soit selectionner à la
     * fois
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void comboImage1Check(ActionEvent event) throws IOException {
        ComboImage2.setSelected(false);
        ComboImage3.setSelected(false);
        ComboImage4.setSelected(false);
        ComboImage5.setSelected(false);
        ComboImage6.setSelected(false);
        lImage = "image1";
    }

    /**
     * Controle de saisi des comboBox pour que 1 seule soit selectionner à la
     * fois
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void comboImage2Check(ActionEvent event) throws IOException {
        ComboImage1.setSelected(false);
        ComboImage3.setSelected(false);
        ComboImage4.setSelected(false);
        ComboImage5.setSelected(false);
        ComboImage6.setSelected(false);
        lImage = "image2";
    }

    /**
     * Controle de saisi des comboBox pour que 1 seule soit selectionner à la
     * fois
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void comboImage3Check(ActionEvent event) throws IOException {
        ComboImage2.setSelected(false);
        ComboImage1.setSelected(false);
        ComboImage4.setSelected(false);
        ComboImage5.setSelected(false);
        ComboImage6.setSelected(false);
        lImage = "image3";
    }

    /**
     * Controle de saisi des comboBox pour que 1 seule soit selectionner à la
     * fois
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void comboImage4Check(ActionEvent event) throws IOException {
        ComboImage2.setSelected(false);
        ComboImage3.setSelected(false);
        ComboImage1.setSelected(false);
        ComboImage5.setSelected(false);
        ComboImage6.setSelected(false);
        lImage = "image4";
    }

    /**
     * Controle de saisi des comboBox pour que 1 seule soit selectionner à la
     * fois
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void comboImage5Check(ActionEvent event) throws IOException {
        ComboImage2.setSelected(false);
        ComboImage3.setSelected(false);
        ComboImage4.setSelected(false);
        ComboImage1.setSelected(false);
        ComboImage6.setSelected(false);
        lImage = "image5";
    }

    /**
     * Controle de saisi des comboBox pour que 1 seule soit selectionner à la
     * fois
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void comboImage6Check(ActionEvent event) throws IOException {
        ComboImage2.setSelected(false);
        ComboImage3.setSelected(false);
        ComboImage4.setSelected(false);
        ComboImage5.setSelected(false);
        ComboImage1.setSelected(false);
        lImage = "image6";
    }
}
