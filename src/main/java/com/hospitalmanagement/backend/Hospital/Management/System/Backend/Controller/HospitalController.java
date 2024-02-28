package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Controller;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Model.Patient;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HospitalController {
    @Autowired
    HospitalService hospitalService;

    @GetMapping("/api/get-patient/hospital")
    public Patient getPatientAtBedNo(@RequestParam int bedNo){
        return hospitalService.getPatientAtBedNo(bedNo);
    }


}
