package com.eci.nyrs.angularnyrs.service;

import com.eci.nyrs.angularnyrs.models.Request;

import java.util.List;

public interface RequestUsersService {

    List<Request> getRequest(String username, Boolean pending);
}
