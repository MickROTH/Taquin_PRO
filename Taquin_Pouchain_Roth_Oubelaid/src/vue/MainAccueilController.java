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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Perso
 */
public class MainAccueilController implements Initializable {

     
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
     @FXML
    private void buttSansSoloOnClick(ActionEvent event) {
         System.out.println("Oh on a cliquer sur moi !");
         
        /*
        JeuSoloConsole jeu = new JeuSoloConsole(); 
        String[] arg = new String[10] ; 
        JeuSoloConsole.main(arg);
        */
    }

    

   
    
}
