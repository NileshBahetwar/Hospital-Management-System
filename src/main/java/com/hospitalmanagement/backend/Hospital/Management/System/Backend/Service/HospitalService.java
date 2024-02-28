package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Service;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Model.Patient;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {

    @Autowired
    HospitalRepository hospitalRepository;

    public int getFirstEmptyBedNo(){
        Patient[] patients=hospitalRepository.getAllBedInfo();
        for(int i=0;i<patients.length;i++){
            if(patients[i]==null){
                return i;  // got 1st empty bed
            }
        }
        return -1;   // no bed is empty
    }

    public Patient getPatientAtBedNo(int bedNo){
        return hospitalRepository.getPatientAtBedNo(bedNo);
    }

    public void assignBedNoToPatient(int bedNo,Patient patient){
        hospitalRepository.assignBedNumberToPatient(bedNo,patient);
    }
}
