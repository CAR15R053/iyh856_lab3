package edu.utsa.cs3443.iyh856_lab3.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AidShipManager {
    //Attributes
    private ArrayList<AidShip> aidShips;

    /**
     * Constructor for AidShipManager
     */
    public AidShipManager(){
        aidShips = new ArrayList<>();
    }

    /**
     * adds a ship to aid ship lists
     * @param ship aid ship
     */
    public void addAidShip(AidShip ship){
        aidShips.add(ship);
    }

    /**
     * Reads information from file and adds it to Arraylist of aid ships
     */
    public void loadAidShips(){
        try {
            String fname = "data.csv";
            File f = new File(fname);
            Scanner s = new Scanner(f);

            //Skips header
            if (s.hasNextLine()) {
                s.nextLine();
            }

            while(s.hasNextLine()) {
                String line = s.nextLine();
                String[] section = line.split(",");

                if (section.length >8){
                    section[4] = section[4] + "," + section[5];
                    String[] fixedLine = new String[8];

                    for(int i=0; i<4; i++){
                        fixedLine[i] = section[i];
                    }

                    fixedLine[4]=section[4];

                    for(int i=5;i<8;i++){
                        fixedLine[i] = section[i+1];
                    }
                    section = fixedLine;
                }

                String name = section[0].trim();
                String regNum = section[1].trim();
                double tonnage = Double.parseDouble(section[2].trim());
                int crewSize = Integer.parseInt(section[3].trim());
                String curPort = section[4].replace("\"", "").trim();
                String aidType= section[5].trim();
                int suppliesOnBoard = Integer.parseInt(section[6].trim());
                boolean hasHelipad = Boolean.parseBoolean(section[7].trim());

                AidShip aidShip = new AidShip(name,regNum,tonnage,crewSize,curPort,aidType,suppliesOnBoard,hasHelipad);
                addAidShip(aidShip);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    /**
     * Takes registration number and searches through array of aidShips, returning a boolean answer
     * @param regNum registration number
     * @return boolean answer
     */
    public AidShip findAidShip(String regNum){
        for(int i=0; i < aidShips.size() ; i++) {
            if(regNum.equals(aidShips.get(i).getRegistrationNumber())){
                return aidShips.get(i);
            }
        }
        return null;
    }

    /**
     * Takes boolean value of findAidShip and returns boolean answer if exists
     * @param regNum registration number
     * @return boolean answer
     */
    public boolean isAidShipExists(String regNum){
        return findAidShip(regNum) != null;
    }

    /**
     * Takes aidShip, finds registration number, return boolean if can be updated
     * @param aidShip aidShip
     * @return boolean if can be updated
     */
    public boolean updateAidShip(AidShip aidShip){
        for(int i=0; i<aidShips.size(); i++){
            if (aidShip.getRegistrationNumber().equals(aidShips.get(i).getRegistrationNumber())){
                return true;
            }
        }
        return false;
    }

    /**
     * Takes registration number of ship and removes it from list of aidShips and returns true of successful, otherwise false
     * @param regNum registration number
     * @return if removed:true, if unable to remove:false
     */
    public boolean deleteAidShip(String regNum){
        for( int i =0; i< aidShips.size(); i++){
            if(regNum.equals(aidShips.get(i).getRegistrationNumber())) {
                aidShips.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Reads line from data.doc and converts it into an AidShip
     * @param l line
     * @return the new aidShip
     */
    public AidShip convertLineToAidShip(String l){
        String[] section = l.split(",");

        if (section.length >8){
            section[4] = section[4] + "," + section[5];
            String[] fixedLine = new String[8];

            for(int i=0; i<4; i++){
                fixedLine[i] = section[i];
            }

            fixedLine[4]=section[4];

            for(int i=5;i<8;i++){
                fixedLine[i] = section[i+1];
            }
            section = fixedLine;
        }

        String name = section[0].trim();
        String regNum = section[1].trim();
        double tonnage = Double.parseDouble(section[2].trim());
        int crewSize = Integer.parseInt(section[3].trim());
        String curPort = section[4].replace("\"", "").trim();
        String aidType= section[5].trim();
        int suppliesOnBoard = Integer.parseInt(section[6].trim());
        boolean hasHelipad = Boolean.parseBoolean(section[7].trim());
        return new AidShip(name,regNum,tonnage,crewSize,curPort,aidType,suppliesOnBoard,hasHelipad);
    }

    /**
     * Takes in aidShip and converts it into a line that is ready to be added to data.doc again
     * @param aidShip aidShip
     * @return new string line of aidShip
     */
    public String convertAidShipToLine(AidShip aidShip){
        String fullPort = aidShip.getCurrentPort();
        if(aidShip.getCurrentPort().contains(",")){
            fullPort = "\"" + fullPort + "\"";
        }
        return aidShip.getName() + "," + aidShip.getRegistrationNumber() + "," + aidShip.getTonnage() + "," + aidShip.getCrewSize() + ","
                + fullPort + "," + aidShip.getAidType() + "," + aidShip.getSuppliesOnBoard() + "," + aidShip.isHasHelipad();
    }

    /**
     * Puts the newly converted AidShipToLine into taken filename and adds new line unless it's the last addition
     * @param fname filename
     * @throws IOException if file not found
     */
    public void saveDataToFile(String fname) throws IOException {
        fname = "data.csv";
        FileWriter w = new FileWriter(fname);
        for(int i=0; i< aidShips.size(); i++){
            String l = convertAidShipToLine(aidShips.get(i));
            w.write(l);

            if(i< aidShips.size() -1 ){
                w.write("\n");
            }
        }
        w.close();
    }


    /**
     * To string that prints out the correctformat of AidShip array list
     * @return AidShip Array list in proper format
     */
    @Override
    public String toString(){
        String output = "";

        for(int i=0; i< aidShips.size(); i++){
            AidShip s = aidShips.get(i);
            output += s.getName() + " | " + s.getRegistrationNumber() + " | " + s.getTonnage() + " | " + s.getCrewSize()
                    + " | " + s.getCurrentPort() + " | " +  s.getAidType() + " | " + s.getSuppliesOnBoard() + " | ";
            if(s.isHasHelipad()){
                output += "Helipad";
            }
            else {
                output += "No Helipad";
            }
            if (i< aidShips.size() -1 ){
                output += "\n";
            }
        }
        return output;
    }

    /**
     * Takes AidShipList and returns aidShips
     * @return aidShips
     */
    public ArrayList<AidShip> getAidShipList() {
        return aidShips;
    }

    /**
     * Takes AidShipList and replaces current one
     * @param aidShip aidShip
     */
    public void setAidShipList(ArrayList<AidShip> aidShip) {
        this.aidShips = aidShip;
    }
}

