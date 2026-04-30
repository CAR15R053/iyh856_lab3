package edu.utsa.cs3443.iyh856_lab4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class LoginScreenController {

    @FXML
    private TextField usernameInfo;
    @FXML
    private PasswordField passwordInfo;
    @FXML
    private Label errorMSG;

    private Stage mainS;


    public void setStage(Stage s){
        this.mainS = s;
    }

    @FXML
    public void loginButtonPressed(ActionEvent event) {
        String UN = usernameInfo.getText();
        String PWD = passwordInfo.getText();

        if (UN.equals("") || PWD.equals("")) {
            errorMSG.setText("Please make sure you have entered both your username and password.");
            return;
        }
        try {
            if (userExists(UN,PWD)){
                goToMain();
            }
            else {
                errorMSG.setText("Username or password is incorrect. Please try again.");
            }
        }
        catch (Exception e){
            errorMSG.setText("Error: Main screen cannot be loaded");
        }
    }

    private void goToMain() throws IOException {
            FXMLLoader l = new  FXMLLoader(AidShipApplication.class.getResource("layouts/main-screen.fxml"));
            Scene sc = new  Scene(l.load(),1000,800);
            mainS.setTitle("The Global Emergency Response Organization");
            mainS.setScene(sc);
            mainS.show();
    }


    private boolean userExists(String username, String password){
        File f = new File("data/users.csv");
        try {
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] sec = line.split(",");
                String user = sec[4].trim();
                String pass = sec[5].trim();

                if (user.equals(username) && pass.equals(password)) {
                    return true;
                }
            }
            s.close();
        }
        catch(FileNotFoundException e){
            errorMSG.setText("Error: user not found");
        }
        return false;
    }





}
