package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Service;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Model.Doctor;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Model.Patient;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;
    public void addDoctor(Doctor doctor){
        String docId="doctor"+(doctorRepository.getOverallDoctors()+1);
        doctor.setDocId(docId);
        doctorRepository.addDoctor(doctor);
    }

    public Doctor getDoctorByDocId(String docId){
       return doctorRepository.getDoctorByDocId(docId);
    }

    public void updateDocByDocId(String docId,Doctor doctor){
        doctorRepository.updateDocByDocId(docId,doctor);
    }

    public Doctor getMinNumberOfPatientOfParticularDoc(){
        HashMap<String, ArrayList<Patient>> noOfPatients=doctorRepository.getMinNumberOfPatientOfParticularDoc();
        int minNoOfPatientSize=Integer.MAX_VALUE;
        Doctor  doctor=null;
        for(String key : noOfPatients.keySet()) {
            ArrayList<Patient> docHandelingPatient = noOfPatients.get(key);
            if (docHandelingPatient.size() < minNoOfPatientSize) {
                minNoOfPatientSize = docHandelingPatient.size();
                doctor=doctorRepository.getDoctorByDocId(key);
            }
        }
        return doctor;
    }

    public int getOverAllDoctor(){
        return doctorRepository.getOverallDoctors();
    }

    public ArrayList<Patient>listOfPatientsHandelByDoc(String dId){
        ArrayList<Patient>listOfPatients=doctorRepository.listOfPatientsHandelByDoc(dId);
        return listOfPatients;
    }


}
