package com.cgm.patients.patientmanagement.service;

import com.cgm.patients.patientmanagement.entity.Patient;
import com.cgm.patients.patientmanagement.model.DeleteResponseModel;
import com.cgm.patients.patientmanagement.model.EmailValidatorResponseModel;
import com.cgm.patients.patientmanagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public Patient savePatient(Patient patient) {
        return repository.save(patient);
    }

    public List<Patient> savePatients(List<Patient> patients) {
        return repository.saveAll(patients);
    }

    public List<Patient> getPatients() {
        return repository.findAll();
    }

    public Patient getPatientById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Patient> getPatientByFirstName(String name) {
        return repository.findByFirstName(name);
    }

    public Patient getPatientByLastName(String name) {
        return repository.findByLastName(name);
    }

    public DeleteResponseModel deletePatient(int id) {
        repository.deleteById(id);
        DeleteResponseModel responseModel = new DeleteResponseModel();
        responseModel.message = "PATIENT_REMOVED_SUCCESSFULLY";
        return responseModel;
    }

    public EmailValidatorResponseModel checkPatient(String email){
        Patient patient = repository.findByEmail(email);
        EmailValidatorResponseModel responseModel = new EmailValidatorResponseModel();
        responseModel.message = "EMAIL_EXIST";
        if(patient == null){
            responseModel.message = "VALID_EMAIL";
        }
        return responseModel;
    }
    public Patient updatePatient(Patient patient) {
        Patient existingPatient = repository.findById(patient.getId()).orElse(null);
        existingPatient.setFirstName(patient.getFirstName());
        existingPatient.setLastName(patient.getLastName());
        existingPatient.setDateOfBirth(patient.getDateOfBirth());
        existingPatient.setAddress(patient.getAddress());
        existingPatient.setInsurance(patient.getInsurance());
        existingPatient.setPhoneNumber(patient.getPhoneNumber());
        existingPatient.setEmail(patient.getEmail());
        return repository.save(existingPatient);
    }

}
