package com.eci.nyrs.angularnyrs.service;

import com.eci.nyrs.angularnyrs.models.Patient;
import com.eci.nyrs.angularnyrs.repositories.PatientRepository;
import com.eci.nyrs.angularnyrs.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServicePersistenceImpl implements PatientService{

    @Autowired
    private PatientRepository patirepo;


    @Override
    public List<Patient> getPatients() {
        return patirepo.findAll();
    }

    @Override
    public Patient createPatient(Patient patient) {
        patirepo.save(patient);
        return patirepo.findOne(patient.getUsername());
    }

    @Override
    public Patient getPatient(String username) {
        return patirepo.findOne(username);
    }

    @Override
    public Patient editPatient(Patient patient) {
        patirepo.save(patient);
        return patirepo.findOne(patient.getUsername());
    }
}
