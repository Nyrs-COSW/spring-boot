package com.eci.nyrs.angularnyrs.service;

import com.eci.nyrs.angularnyrs.models.Request;
import com.eci.nyrs.angularnyrs.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServicePersistenceImpl implements RequestService {

    @Autowired
    private RequestRepository reqrepo;

    @Override
    public List<Request> getRequest(String username, Boolean pending) {
        return null;
    }

    @Override
    public Request getRequestByCode(String code) {
        return null;
    }

    @Override
    public String acceptRequest(String code) {
        return null;
    }

    @Override
    public List<Request> getAllRequest() {
        return reqrepo.findAll();
    }
}
