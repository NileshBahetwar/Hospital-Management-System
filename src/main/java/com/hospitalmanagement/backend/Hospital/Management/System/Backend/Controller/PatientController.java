package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Controller;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Model.Doctor;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Model.Patient;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {
    @Autowired
    PatientService patientService;

    @PostMapping("/api/add/patient")
    public String addPatient(@RequestBody Patient patient){
        patientService.addPatient(patient);
        return "patient has been added successfully";
    }

    @GetMapping("/api/get/patient")
    public Patient getPatientById(@RequestParam String pId){
       return patientService.getPatientById(pId);
    }

    @DeleteMapping("/api/delete/patient")
    public String dischargePatientById(@RequestParam String pId){
        patientService.dischargePatientById(pId);
        return "patient has been discharged";
    }

    @GetMapping("/api/total/patient")
    public int totalPatient(){
        return patientService.totalPatient();
    }

    @GetMapping("/api/overall/patient")
    public int overAllPatients(){
        return patientService.getOverAllPatients();
    }

    @GetMapping("/api/patient/get-doctor/{pId}")
    public Doctor getPatientsDoctor(@PathVariable String pId){
        return patientService.getPatientsDoctor(pId);
    }

    
}
