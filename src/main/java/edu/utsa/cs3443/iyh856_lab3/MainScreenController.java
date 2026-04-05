package edu.utsa.cs3443.iyh856_lab3;

import edu.utsa.cs3443.iyh856_lab3.model.AidShip;
import edu.utsa.cs3443.iyh856_lab3.model.AidShipManager;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainScreenController {

    /**
     * creates aidshipmanager to be able to find, delete, and print
     */
    @FXML
    private AidShipManager m = new AidShipManager();

    /**
     * displays output text in outputText box
     */
    @FXML
    private TextArea outputText;

    /**
     * find button
     */
    @FXML
    private RadioButton findButton;

    /**
     * delete button
     */
    @FXML
    private RadioButton deleteButton;

    /**
     * text field for registration ship number search
     */
    @FXML
    private TextField enterRegistrationNumberText;

    /**
     * initializes controller objects with names, and creates aidShipManager and loads aidShip data from aid_Ship.cvs
     */
    @FXML
    public void initialize(){
        m = new AidShipManager();
        m.loadAidShips();
    }

    /**
     * When Ship List button is clicked, all aidShips will be printed in specific format in outputText
     */
    @FXML
    private void printShipList() {
        String output =  "AidShipCoordinator List has " + m.getAidShipList().size() + " responders\n"
                + "-----------------------------------------------------------------------------------------------------------------------------------------------\n";
        output += String.format("%-14s | %-19s | %-8s | %-9s | %-20s | %-21s | %-17s | %-12s%n","Name"
                ,"Registration Number","Tonnage", "Crew Size","Current Port", "Aid Type","Supplies On Board","Helipad")
                + "-----------------------------------------------------------------------------------------------------------------------------------------------\n";
        for (int i = 0; i < m.getAidShipList().size(); i++) {
            AidShip s = m.getAidShipList().get(i);
            output += String.format("%-14s | %-19s | %-8.2f | %-9d | %-20s | %-21s | %-17d | %-12s%n", s.getName(), s.getRegistrationNumber(), s.getTonnage(),
                    s.getCrewSize(), s.getCurrentPort(), s.getAidType(), s.getSuppliesOnBoard(), s.isHasHelipad() ? "Available" : "Not Available");
        }
        outputText.setText(output);
    }

    /**
     * When go button is pressed it will check if registration Number Text is empty, if so sends error text,
     * if not empty then will either search through aidShipList for registration number, or use registration
     * number to delete ship with that regNum
     */
    @FXML
    private void pressGo(){
        String regNum = enterRegistrationNumberText.getText();
        //if empty
        if(regNum.isEmpty()){
            outputText.setText("Please enter a valid registration number.");
            return;
        }

        if(findButton.isSelected()){
            AidShip findShip = m.findAidShip(regNum);
            if(findShip != null) {
                outputText.setText(printFindShip(findShip));
            }
            else {
                outputText.setText("No ship was found relating to registration number: " + regNum);
            }
        }
        else if(deleteButton.isSelected()) {
            boolean isRemoved = m.deleteAidShip(regNum);
            if(isRemoved){
                outputText.setText("Ship registration number: " + regNum + " has been deleted.");
            }
            else {
                outputText.setText("Ship registration number: " + regNum + " could not be found and deleted.");
            }
        }
        else{
            outputText.setText("Please select to either FIND or DELETE a ship");
        }
    }

    /**
     * correctly prints and organizes aidShip's toString information
     * @param s aidShip name
     * @return aidShip toString
     */
    @FXML
    private String printFindShip(AidShip s) {
        String output ="Aid Ship Card Found:\n";
        output += "---------------------------------------\n";
        output += String.format("%-22s %s%n","Name:",s.getName()) + String.format("%-22s %s%n", "Registration Number:", s.getRegistrationNumber())
        + String.format("%-22s %.2f%n", "Tonnage:", s.getTonnage())+ String.format("%-22s %d%n", "Crew Size:",s.getCrewSize())
        + String.format("%-22s %s%n","Current Port:", s.getCurrentPort())+ String.format("%-22s %s%n" ,"Aid Type:",s.getAidType())
        + String.format("%-22s %d%n","Supplies On Board:",s.getSuppliesOnBoard());

        //Helipad if else check
        String hStatus;
        if(s.isHasHelipad()) {
            hStatus = "Available";
        }
        else {
            hStatus = "Not Available";
        }
        output += String.format("%-22s %s%n", "Helipad:", hStatus);
        output += "--------------------------------------\n";

        return output;
    }

    /**
     * return aidshipmanager name
     * @return aidshipmanager name
     */
    public AidShipManager getAidShipManager(){
        return m;
    }

    /**
     * sets aidshipmanager
     * @param m aidshipmanager name
     */
    public void setAidShipManager(AidShipManager m){
        this.m = m;
    }
}
