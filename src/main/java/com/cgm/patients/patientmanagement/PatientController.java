package com.cgm.patients.patientmanagement;

import com.cgm.patients.patientmanagement.entity.Patient;
import com.cgm.patients.patientmanagement.model.DeleteResponseModel;
import com.cgm.patients.patientmanagement.model.EmailValidatorResponseModel;
import com.cgm.patients.patientmanagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientService service;
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addPatient")
    public Patient addPatient(@RequestBody Patient patient) {
        return service.savePatient(patient);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/checkPatient")
    public EmailValidatorResponseModel checkPatient(@RequestBody String patient) {
        return service.checkPatient(patient);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addPatients")
    public List<Patient> addPatients(@RequestBody List<Patient> patients) {
        return service.savePatients(patients);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/patients")
    public List<Patient> findAllPatients() {
        return service.getPatients();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/patientById/{id}")
    public Patient findPatientById(@PathVariable int id) {
        return service.getPatientById(id);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/patient/{name}")
    public List<Patient> findPatientByFirstName(@PathVariable String name) {
        return service.getPatientByFirstName(name);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/update")
    public Patient updatePatient(@RequestBody Patient patient) {
        return service.updatePatient(patient);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/delete/{id}")
    public DeleteResponseModel deletePatient(@PathVariable int id) {
        return service.deletePatient(id);
    }
}
