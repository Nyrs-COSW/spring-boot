package com.eci.nyrs.angularnyrs.controller;

import com.eci.nyrs.angularnyrs.models.Nurse;
import com.eci.nyrs.angularnyrs.models.Nursingservices;
import com.eci.nyrs.angularnyrs.models.Patient;
import com.eci.nyrs.angularnyrs.models.User;
import com.eci.nyrs.angularnyrs.service.NurseService;
import com.eci.nyrs.angularnyrs.service.NursingservicesService;
import com.eci.nyrs.angularnyrs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/user" )
public class NurseController {

    @Autowired
    private UserService nurseService;

    @Autowired
    private NurseService nurService;

    @CrossOrigin
    @RequestMapping(value = "/nurse", method = RequestMethod.POST)
    public ResponseEntity<?> newNurse(@RequestBody Nurse nurse) {
        return new ResponseEntity<>(nurseService.createNurse(nurse), HttpStatus.ACCEPTED);
    }

    @CrossOrigin
    @RequestMapping(value = "/allNurse", method = RequestMethod.GET)
    public ResponseEntity<?> getAllNurse() {
        return new ResponseEntity<>(nurService.getNurse(), HttpStatus.ACCEPTED);
    }

    @CrossOrigin
    @RequestMapping( value = "/nurse/{username}", method = RequestMethod.GET )
    public Nurse getNurseByUsername(@PathVariable("username") String username) {
        return nurService.getNurse(username);
    }

    @CrossOrigin
    @RequestMapping( value = "/personal/{service}", method = RequestMethod.GET )
    public List<Nurse> getNursingPersonalByService(@PathVariable("service") String service) {
        return nurseService.getNursingPersonalByService(service);
    }
}
