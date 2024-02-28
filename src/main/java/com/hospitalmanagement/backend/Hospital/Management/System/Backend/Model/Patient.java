package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Model;

public class Patient {
    private String pId;
    private String patientName;
    private int patientAge;
    private String patientAddress;
    private String patientDisease;

    public Patient() {
    }

    public Patient(String pId, String patientName, int patientAge, String patientAddress, String patientDisease) {
        this.pId = pId;
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.patientAddress = patientAddress;
        this.patientDisease = patientDisease;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientDisease() {
        return patientDisease;
    }

    public void setPatientDisease(String patientDisease) {
        this.patientDisease = patientDisease;
    }
}
