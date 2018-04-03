package com.eci.nyrs.angularnyrs.service;

import com.eci.nyrs.angularnyrs.models.Patient;

import java.util.List;

public interface PatientService
{
    List<Patient> getPatients();
    Patient createPatient( Patient patient );
    Patient getPatient(String username);

}
