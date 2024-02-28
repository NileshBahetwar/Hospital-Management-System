package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repository;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Model.Doctor;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Model.Patient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class DoctorRepository {
    private HashMap<String, Doctor> doctorDB;
    private HashMap<String, ArrayList<Patient>> docVsPatientDB;
    private int overallDoctors;

    public DoctorRepository(){
        this.docVsPatientDB=new HashMap<>();
        this.doctorDB=new HashMap<>();
        this.overallDoctors=0;
    }

    public void addDoctor(Doctor doctor){
        this.overallDoctors+=1;
        doctorDB.put(doctor.getDocId(),doctor);
        docVsPatientDB.put(doctor.getDocId(),new ArrayList<>());
    }

    public Doctor getDoctorByDocId(String docId){
        return doctorDB.get(docId);
    }

    public void updateDocByDocId(String docId,Doctor doctor){
          doctorDB.put(docId,doctor);
    }

    public int getOverallDoctors() {
        return this.overallDoctors;
    }

    public void assignPatientsToADoctor(String docId,Patient patient){
        ArrayList<Patient>patients = this.docVsPatientDB.get(docId);
        patients.add(patient);
    }

    public HashMap<String, ArrayList<Patient>> getMinNumberOfPatientOfParticularDoc(){
       return this.docVsPatientDB;
    }

    public ArrayList<Patient>listOfPatientsHandelByDoc(String dId){
        return this.docVsPatientDB.get(dId);
    }

}
