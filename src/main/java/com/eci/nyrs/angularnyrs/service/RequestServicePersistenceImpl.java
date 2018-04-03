package com.eci.nyrs.angularnyrs.service;

import com.eci.nyrs.angularnyrs.models.Request;
import com.eci.nyrs.angularnyrs.repositories.RequestRepository;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RequestServicePersistenceImpl implements RequestService {

    @Autowired
    private RequestRepository reqrepo;

    //public List<Request> requesL = reqrepo.findAll();

    @Override
    public List<Request> getRequest(String username, Boolean pending) {

        List<Request> requesL = reqrepo.findAll();
        List<Request> nursesRequest = new ArrayList<>();
        for (int i = 0; i < requesL.size() ; i++) {
            if(requesL.get(i).getNurse().getUsername().equals(username) && requesL.get(i).getAccepted().equals(pending) ){
                nursesRequest.add(requesL.get(i));
            }
        }
        return nursesRequest;
    }

    @Override
    public Request getRequestByCode(int code) {
        List<Request> requesL = reqrepo.findAll();
        Request rqst= null;
        for (int i = 0; i < requesL.size() ; i++) {
            if(requesL.get(i).getCode() == code){
                rqst = requesL.get(i);
            }
        }
        return rqst;
    }

    @Override
    public String acceptRequest(int code) {
        List<Request> requesL = reqrepo.findAll();
        String accept = null;
        for (int i = 0; i < requesL.size() ; i++) {
            if(requesL.get(i).getCode() == code){
                requesL.get(i).setAccepted(true);
                accept = Integer.toString(code);
            }
        }
        return accept;
    }

    @Override
    public List<Request> getAllRequest() {
        return reqrepo.findAll();
    }
}
