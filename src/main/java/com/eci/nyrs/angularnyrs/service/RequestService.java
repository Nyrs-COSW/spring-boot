package com.eci.nyrs.angularnyrs.service;

import com.eci.nyrs.angularnyrs.models.Request;

import java.util.List;

public interface RequestService {

    List<Request> getRequest(String username, Boolean pending);

    Request getRequestByCode(String code);

    String acceptRequest(String code);

    List<Request> getAllRequest();
}
