package edu.utsa.cs3443.iyh856_lab4;

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
        FXMLLoader fxmlLoader = new FXMLLoader(AidShipApplication.class.getResource("layouts/login-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),600,277);
        LoginScreenController con = fxmlLoader.getController();
        con.setStage(stage);
        stage.setTitle("GERO Login");
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
