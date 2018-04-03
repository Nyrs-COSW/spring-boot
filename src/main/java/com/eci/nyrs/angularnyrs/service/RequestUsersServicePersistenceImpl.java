package com.eci.nyrs.angularnyrs.service;

import com.eci.nyrs.angularnyrs.models.Request;
import com.eci.nyrs.angularnyrs.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RequestUsersServicePersistenceImpl implements RequestUsersService{

    @Autowired
    private RequestRepository requesUserServices ;


    //public List<Request> requestUserServices = requesUserServices.findAll();

    @Override
    public List<Request> getRequest(String username, Boolean pending) {
        List<Request> requestUserServices = requesUserServices.findAll();
        List<Request> UserRequest = new ArrayList<>();
        for (int i = 0; i < requestUserServices.size() ; i++) {
            if(requestUserServices.get(i).getPatient().getUsername().equals(username) && requestUserServices.get(i).getAccepted().equals(pending)){
                UserRequest.add(requestUserServices.get(i));
            }
        }
        return UserRequest;
    }
}
