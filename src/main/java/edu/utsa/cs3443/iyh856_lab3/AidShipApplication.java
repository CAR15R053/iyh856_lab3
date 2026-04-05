package edu.utsa.cs3443.iyh856_lab3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class AidShipApplication extends Application {
    /**
     * start is ran when application is launched, displays window
     * @param stage stage is app window
     * @throws IOException if fails
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AidShipApplication.class.getResource("layouts/main-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1000,800);
        stage.setTitle("The Global Emergency Response Organization");
        stage.setScene(scene);
        stage.show();
    }

    /**
     *launches application
     */
    public static void main(String[] args){
        launch();
    }
}
