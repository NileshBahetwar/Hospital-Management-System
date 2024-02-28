package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Controller;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Model.Doctor;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Model.Patient;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @PostMapping("/api/add/doctor")
    public String addDoctor(@RequestBody Doctor doctor){
        doctorService.addDoctor(doctor);
        return "doctor got added successfully";
    }

    @GetMapping("/api/get/doctor")
    public Doctor getDoctorByDocId(@RequestParam String docId){
       return doctorService.getDoctorByDocId(docId);
    }

    @PutMapping("/api/update/doctor")
    public String updateDocByDocId(@RequestParam String docId,@RequestBody Doctor doctor){
        doctorService.updateDocByDocId(docId,doctor);
        return "doctor data got updated";
    }

    @GetMapping("/api/get/total/doctor")
    public int getOverAllDoctor(){
        return doctorService.getOverAllDoctor();
    }

    @GetMapping("/api/get/all-patients/{docId}")
    public ArrayList<Patient> listOfPatientsHandelByDoc(@PathVariable String docId){
       return doctorService.listOfPatientsHandelByDoc(docId);
    }


}
