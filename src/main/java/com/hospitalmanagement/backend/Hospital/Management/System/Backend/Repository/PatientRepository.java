package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repository;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Model.Doctor;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Model.Patient;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class PatientRepository {
    private HashMap<String,Patient>patientDB;
    private HashMap<String, Doctor> patientVsDoctorDB;
    private int overAllPatient;

    public PatientRepository(){
        this.overAllPatient=0;
        this.patientDB=new HashMap<>();
        this.patientVsDoctorDB=new HashMap<>();
    }

    public void addPatient(Patient patient){
        this.overAllPatient+=1;
        this.patientDB.put(patient.getpId(),patient);
    }

    public Patient getPatientById(String patientId){
        return this.patientDB.get(patientId);
    }

    public void dischargePatientById(String pId){
        this.patientDB.remove(pId);
    }

    public int totalPatient(){
        return this.patientDB.size();
    }

    public int overallPatients(){
        return this.overAllPatient;
    }

    public void assignDoctorToPatient(String pId,Doctor doctor){
        this.patientVsDoctorDB.put(pId, doctor);
    }

    public Doctor getPatientsDoctor(String pId){
        return patientVsDoctorDB.get(pId);
    }
}
