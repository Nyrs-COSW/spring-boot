package com.eci.nyrs.angularnyrs.service;

import com.eci.nyrs.angularnyrs.models.Request;

import java.util.List;

public interface RequestService {

    List<Request> getRequest(String username, Boolean pending);

    Request getRequestByCode(int code);

    String acceptRequest(int code);

    List<Request> getAllRequest();
}
