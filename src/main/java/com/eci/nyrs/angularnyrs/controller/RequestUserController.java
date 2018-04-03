package com.eci.nyrs.angularnyrs.controller;

import com.eci.nyrs.angularnyrs.models.Request;
import com.eci.nyrs.angularnyrs.service.RequestUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/requestsUsers" )
public class RequestUserController {

    @Autowired
    private RequestUsersService requestusersservice;

    @CrossOrigin
    @RequestMapping( value = "/{username}/{pending}", method = RequestMethod.GET )
    public List<Request> getRequest(@PathVariable("username") String username, @PathVariable("pending") Boolean pending) {

        return requestusersservice.getRequest(username, pending);
    }

}