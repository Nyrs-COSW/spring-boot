package com.eci.nyrs.angularnyrs.service;


import com.eci.nyrs.angularnyrs.models.Patient;

import com.eci.nyrs.angularnyrs.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//@Service
public class PatientServiceImpl implements PatientService {

    private List<Patient> patients = new ArrayList<>();


    @Autowired
    public PatientServiceImpl()
    {
    }
    @PostConstruct
    private void populateSampleData()
    {

        Patient p1 = new Patient( "patient@mail.com", "1234", "Ernesto", "Sarmiento", "PacienteErnesto",40,13354841,165189 );
        Patient p2 =  new Patient( "javier.silva@mail.escuelaing.edu.co", "1234", "Javier", "Silva", "JavierSilva",23, 234542,1234 );
        Patient p3 = new Patient( "leonardo.castro@mail.escuelaing.edu.co", "1234", "Leonardo", "Castro", "LeonardoCastro" , 21, 23345342,10);

        patients.add(p1);
        patients.add(p2);
        patients.add(p3);
    }
    @Override
    public Patient createPatient(Patient patient) {
        patients.add(patient);
        return patients.get(0);
    }

    @Override
    public Patient getPatient(String username) {
        Patient paciente = null;

        for (int i=0; i < patients.size();i++){
            if (patients.get(i).getUsername().equals(username)) {

                paciente = patients.get(i);
            }
        }
        return paciente;
    }

    @Override
    public List<Patient> getPatients()
    {
        return patients;
    }





}
