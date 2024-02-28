package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Service;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Model.Doctor;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Model.Patient;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repository.DoctorRepository;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PatientService {
    @Autowired
    HospitalService hospitalService;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorService doctorService;  // for assigning doctor to a patient
    @Autowired
    DoctorRepository doctorRepository; // for assigning patient to doctor
    public void addPatient(Patient patient){

        String pId="patient"+(patientRepository.overallPatients()+1);
        patient.setpId(pId);

        patientRepository.addPatient(patient);

        int bedNo=hospitalService.getFirstEmptyBedNo();
        hospitalService.assignBedNoToPatient(bedNo,patient);

        Doctor doctor = doctorService.getMinNumberOfPatientOfParticularDoc();
        patientRepository.assignDoctorToPatient(pId,doctor);

        doctorRepository.assignPatientsToADoctor(doctor.getDocId(),patient);

    }

    public Patient getPatientById(String pId){
       return patientRepository.getPatientById(pId);
    }

    public void dischargePatientById(String pId){
        patientRepository.dischargePatientById(pId);
    }

    public int totalPatient(){
       return patientRepository.totalPatient();
    }

    public int getOverAllPatients(){
        return patientRepository.overallPatients();
    }

//    public void assignDoctorToPatient(Patient patient){
//        patientRepository.assignDoctorToPatient(patient.getpId(),);
//    }

    public Doctor getPatientsDoctor(String pId){
       return patientRepository.getPatientsDoctor(pId);
    }

}
