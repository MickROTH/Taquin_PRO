package fxml;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EcranPartie extends Application {

    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;
        stage.setTitle("Taquin TROP BIEN");
        chargeVueGraphique();
    }
    private void chargeVueGraphique(){
        // Chargement du fichier fxml
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(EcranPartie.class.getResource("MainGraphiqueAccueil.fxml"));
    // Chargement de l'interface graphique dans un objet
        Parent vue = null;
        try {
            vue = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Encapsulation de l'interface graphique dans la scène
        Scene scene = new Scene(vue);
        stage.setScene(scene);
        stage.show();
}
    
}
