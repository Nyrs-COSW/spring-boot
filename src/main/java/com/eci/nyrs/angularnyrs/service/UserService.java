package com.eci.nyrs.angularnyrs.service;

import com.eci.nyrs.angularnyrs.models.User;

import java.util.List;

public interface UserService
{
    List<User> getPatients();

    User getUser( String username );

    User createPatient( User user );

    User createNurse (User user);

    User findUserByEmail( String email );

    User findUserByEmailAndPassword( String email, String password );

    List<User> getNursingPersonalByService(String service);

    User editNurse(User nurse);

    List<User> getAllNurse ();

    User editPatient(User patient);





}