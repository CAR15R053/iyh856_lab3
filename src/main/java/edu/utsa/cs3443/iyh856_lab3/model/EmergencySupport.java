package edu.utsa.cs3443.iyh856_lab3.model;

public interface EmergencySupport {

    /**
     * Deploy supporter to aid
     */
    public void deployAid();

    /**
     * Print emergency readiness report
     *
     * @return emergency readiness report
     */
    public String getEmergencyReadinessReport();
}