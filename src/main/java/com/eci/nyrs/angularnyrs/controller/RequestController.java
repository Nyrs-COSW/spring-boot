package com.eci.nyrs.angularnyrs.controller;

import com.eci.nyrs.angularnyrs.models.Request;
import com.eci.nyrs.angularnyrs.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api" )
public class RequestController {

    @Autowired
    private RequestService requestservice;

    @CrossOrigin
    @RequestMapping( value = "/requests/{username}/{pending}", method = RequestMethod.GET )
    public List<Request> getRequest(@PathVariable("username") String username, @PathVariable("pending") Boolean pending) {

        return requestservice.getRequest(username, pending);
    }

    @CrossOrigin
    @RequestMapping( value = "/requests", method = RequestMethod.GET )
    public List<Request> getAllRequest() {
        return requestservice.getAllRequest();
    }

    @CrossOrigin
    @RequestMapping( value = "/requests/{code}", method = RequestMethod.GET )
    public Request getRequest(@PathVariable("code") String code) {
        return requestservice.getRequestByCode(code);
    }

    @CrossOrigin
    @RequestMapping(value = "/requests/accepet/{requestcode}", method = RequestMethod.POST)
    public ResponseEntity<?> newPatient(@RequestBody String requestcode) {

        return new ResponseEntity<>(requestservice.acceptRequest(requestcode), HttpStatus.ACCEPTED);

    }


}