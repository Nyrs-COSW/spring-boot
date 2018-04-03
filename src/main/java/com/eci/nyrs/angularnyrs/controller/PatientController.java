package com.eci.nyrs.angularnyrs.controller;


import com.eci.nyrs.angularnyrs.models.Patient;
import com.eci.nyrs.angularnyrs.models.User;
import com.eci.nyrs.angularnyrs.service.PatientService;
import com.eci.nyrs.angularnyrs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class PatientController {

    @Autowired
    private UserService patientService;

    @Autowired
    private PatientService patients;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> getPatients() {
        return patientService.getUsers();
    }

    @CrossOrigin
    @RequestMapping(value = "/patient", method = RequestMethod.POST)
    public ResponseEntity<?> newPatient(@RequestBody Patient patient) {

            return new ResponseEntity<>(patients.createPatient(patient), HttpStatus.ACCEPTED);

    }

    @CrossOrigin
    @RequestMapping(value = "/patient/{username}", method = RequestMethod.GET)
    public ResponseEntity<?> getPatient(@PathVariable("username") String username) {

        return new ResponseEntity<>( patients.getPatient(username) ,HttpStatus.ACCEPTED);

    }

    @CrossOrigin
    @RequestMapping( value = "/prueba", method = RequestMethod.GET )
    public ResponseEntity<?> prueba() throws ServletException, SQLException {
        return new ResponseEntity<>( patients.getPatients(),HttpStatus.ACCEPTED);

    }

}
