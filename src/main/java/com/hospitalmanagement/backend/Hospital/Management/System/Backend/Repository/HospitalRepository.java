package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repository;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Model.Patient;
import org.springframework.stereotype.Repository;

@Repository
public class HospitalRepository {
    private Patient[] beds;

    public HospitalRepository(){
        this.beds=new Patient[500];
    }

   public void assignBedNumberToPatient(int bedNo,Patient patient){
        beds[bedNo]=patient;
   }

   public Patient getPatientAtBedNo(int bedNo){
        return beds[bedNo];
   }

   public Patient[] getAllBedInfo(){
        return beds;
   }
}
