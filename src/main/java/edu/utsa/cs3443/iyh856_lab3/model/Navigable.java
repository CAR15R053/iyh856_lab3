package edu.utsa.cs3443.iyh856_lab3.model;

public interface Navigable {

    /**
     * Sets new destination for ship
     *
     * @param destination new current port
     */
    public void navigateTo(String destination);

    /**
     * Set new speed for ship
     *
     * @param speed new current speed
     */
    public void setCurrentSpeed(double speed);

    /**
     * Get current speed for ship
     *
     * @return current speed
     */
    public double getCurrentSpeed();
}