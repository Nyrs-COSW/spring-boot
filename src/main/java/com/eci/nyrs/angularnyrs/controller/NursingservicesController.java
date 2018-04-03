package com.eci.nyrs.angularnyrs.controller;

import com.eci.nyrs.angularnyrs.models.Nursingservices;
import com.eci.nyrs.angularnyrs.service.NursingservicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api" )
public class NursingservicesController {

    @Autowired
    private NursingservicesService nursingservicesservice;

    @CrossOrigin
    @RequestMapping( value = "/nursingservices", method = RequestMethod.GET )
    public List<Nursingservices> getNursingServices() {
        return nursingservicesservice.getNursingservices();
    }

}