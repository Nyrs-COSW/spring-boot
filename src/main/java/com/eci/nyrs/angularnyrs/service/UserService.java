package com.eci.nyrs.angularnyrs.service;

import com.eci.nyrs.angularnyrs.models.Nurse;
import com.eci.nyrs.angularnyrs.models.Patient;
import com.eci.nyrs.angularnyrs.models.User;

import javax.servlet.ServletException;
import java.sql.SQLException;
import java.util.List;

public interface UserService
{
    List<User> getUsers();

    User getUser( String username );

    Patient createPatient( Patient user );

    Nurse createNurse (Nurse user);

    User findUserByEmail( String email );

    User findUserByEmailAndPassword( String email, String password );

    List<Nurse> getNursingPersonalByService(String service);

}