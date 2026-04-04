package edu.utsa.cs3443.iyh856_lab3;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class AidShipApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(AidShipApplication.class.getResource("/edu/utsa/cs3443/iyh856_lab3/layouts/main-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1920,1080);
        stage.setTitle("The Global Emergency Response Organization");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch();
    }

}
