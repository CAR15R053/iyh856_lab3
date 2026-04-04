package edu.utsa.cs3443.iyh856_lab3.model;

public abstract class Ship implements Navigable{
    //Attributes for Ship Class
    private String name;
    private String regNum;
    private double tonnage;
    private int crewSize;
    private double curSpeed;
    private String curPort;


    /**
     * Constructor for ship with all attributes
     * @param name name
     * @param regNum registration number
     * @param tonnage tonnage
     * @param crewSize crew size
     * @param curSpeed current speed
     * @param curPort current port
     */
    public Ship(String name, String regNum, double tonnage, int crewSize, double curSpeed, String curPort){
        this.name = name;
        this.regNum = regNum;
        this.tonnage = tonnage;
        this.crewSize = crewSize;
        this.curSpeed = curSpeed;
        this.curPort = curPort;
    }

    /**
     * Constructor for ship
     *
     * @param name name
     * @param regNum registration number
     * @param tonnage tonnage
     * @param crewSize crew size
     * @param curPort current port
     */
    public Ship(String name, String regNum, double tonnage, int crewSize, String curPort) {
        this.name = name;
        this.regNum = regNum;
        this.tonnage = tonnage;
        this.crewSize = crewSize;
        this.curPort = curPort;
    }

    /**
     * Takes new port to update current port and current speed
     *
     * @param newPort the new port
     */
    public void dock(String newPort){
        curPort = newPort;
        curSpeed = 0;
    }

    /**
     * Set Ship name
     *
     * @param name the name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Set Ship registration number
     *
     * @param regNum the registration number
     */
    public void setRegistrationNum(String regNum){
        this.regNum = regNum;
    }

    /**
     * Set Ship weight in tons
     *
     * @param tonnage the tonnage
     */
    public void setTonnage(double tonnage){
        this.tonnage = tonnage;
    }

    /**
     * Set Ship crew size
     *
     * @param crewSize thecrew size
     */
    public void setCrewSize(int crewSize){
        this.crewSize = crewSize;
    }

    /**
     * Set Ship current speed
     *
     * @param curSpeed the current speed
     */
    public void setCurrentSpeed(double curSpeed){
        this.curSpeed = curSpeed;
    }

    /**
     * Set Ship current port
     *
     * @param curPort the current port
     */
    public void setCurrentPort(String curPort){
        this.curPort = curPort;
    }

    /**
     * Get Ship name
     *
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     * Get Ship registration number
     *
     * @return the registration number
     */
    public String getRegistrationNumber(){
        return regNum;
    }

    /**
     * Get Ship weight in tons
     *
     * @return the tonnage
     */
    public double getTonnage(){
        return tonnage;
    }

    /**
     * Get Ship crew size
     *
     * @return the crew size
     */
    public int getCrewSize(){
        return crewSize;
    }

    /**
     * Get Ship current speed
     *
     * @return the current speed
     */
    public double getCurSpeed(){
        return curSpeed;
    }

    /**
     * Get Ship current port
     *
     * @return the current port
     */
    public String getCurrentPort(){
        return curPort;
    }

    /**
     * Print Ship information
     *
     * @return the ship information
     */
    @Override
    public String toString(){
        return "Ship [name=" + name + ", registrationNumber=" + regNum + ", tonnage=" + tonnage + ", crewSize=" + crewSize + ", currentSpeed=" + curSpeed + ", currentPort=" + curPort;
    }
}