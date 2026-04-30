package edu.utsa.cs3443.iyh856_lab4.model;

public class AidShip extends Ship implements EmergencySupport {
    //Attributes for AidShip
    private String aidType;
    private int suppliesOnBoard;
    private boolean hasHelipad;

    /**
     * Constructor to make ship
     * @param name name
     * @param regNum registration number
     * @param tonnage tonnage
     * @param crewSize crew size
     * @param curSpeed current speed
     * @param curPort current port
     * @param aidType aid type
     * @param suppliesOnBoard supplies on board
     * @param hasHelipad has helipad
     */
    public AidShip(String name, String regNum, double tonnage, int crewSize, double curSpeed, String curPort, String aidType, int suppliesOnBoard, boolean hasHelipad){
        super(name, regNum, tonnage, crewSize, curSpeed, curPort);
        this.aidType = aidType;
        this.suppliesOnBoard = suppliesOnBoard;
        this.hasHelipad = hasHelipad;
    }

    /**
     * Constructor to make Ship
     * @param name name
     * @param regNum registration number
     * @param tonnage tonnage
     * @param crewSize crew size
     * @param curPort current port
     * @param aidType aid type
     * @param suppliesOnBoard supplies on board
     * @param hasHelipad has helipad
     */
    public AidShip(String name, String regNum, double tonnage, int crewSize, String curPort, String aidType, int suppliesOnBoard, boolean hasHelipad){
        super(name, regNum, tonnage, crewSize, curPort);
        this.aidType = aidType;
        this.suppliesOnBoard = suppliesOnBoard;
        this.hasHelipad = hasHelipad;
    }

    /**
     * Docks ship, updates current port with new port and unloads supplies
     *
     * @param newPort the new port
     */
    @Override
    public void dock(String newPort){
        super.dock(newPort);
        unloadSupplies();
    }

    /**
     * Set ship supplies to zero
     */
    private void unloadSupplies(){
        suppliesOnBoard = 0;
    }

    /**
     * Set ship aid type
     *
     * @param aidType aid type
     */
    public void setAidType(String aidType){
        this.aidType = aidType;
    }

    /**
     * Get aid type on Ship
     *
     * @return aid type
     */
    public String getAidType(){
        return aidType;
    }

    /**
     * Set number of supplies on board ship
     *
     * @param suppliesOnBoard supplies on board
     */
    public void setSuppliesOnBoard(int suppliesOnBoard){
        this.suppliesOnBoard = suppliesOnBoard;
    }

    /**
     * Get number of supplies on board ship
     *
     * @return supplies on board
     */
    public int getSuppliesOnBoard(){
        return suppliesOnBoard;
    }

    /**
     * Set availability of ship helipad
     *
     * @param hasHelipad has helipad
     */
    public void setHasHelipad(boolean hasHelipad){
        this.hasHelipad = hasHelipad;
    }

    /**
     * Get availability of ship helipad
     *
     * @return ship helipad
     */
    public boolean isHasHelipad(){
        return hasHelipad;
    }

    /**
     * Print ship toString containing information
     *
     * @return toString
     */
    public String toString(){
        return super.toString() + ", aidType=" + aidType + ", suppliesOnBoard=" + suppliesOnBoard + ", hasHelipad=" + hasHelipad + " ]";
    }

    /**
     * Prints ship emergency readiness report
     *
     * @return emergency readiness report
     */
    public String getEmergencyReadinessReport(){
        System.out.println("AidShip Emergency Report:");
        System.out.println("Name: " + getName());
        System.out.println("Aid Type: " + aidType);
        System.out.println("Supplies on Board: " + suppliesOnBoard);
        if(hasHelipad) {
            System.out.print("Helipad: Available");
        }
        else {
            System.out.print("Helipad: Unavailable");
        }
        return "";
    }


    /**
     * Deploys ship for aid and prints status
     */
    @Override
    public void deployAid() {
        System.out.println("Aid Ship " + super.getName() + " is deploying " + suppliesOnBoard + " units of " + aidType + " aid.");
    }

    /**
     * Updates current port with destination
     *
     * @param destination new current port
     */
    @Override
    public void navigateTo(String destination) {
        super.setCurrentPort(destination);
    }

    /**
     * Set ship current speed
     *
     * @param speed new current speed
     */
    @Override
    public void setCurrentSpeed(double speed) {
        super.setCurrentSpeed(speed);
    }

    /**
     * Get ship current speed
     *
     * @return current speed
     */
    @Override
    public double getCurrentSpeed() {
        return super.getCurSpeed();
    }
}