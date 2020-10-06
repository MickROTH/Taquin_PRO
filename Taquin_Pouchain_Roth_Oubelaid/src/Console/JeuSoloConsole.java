/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

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
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
