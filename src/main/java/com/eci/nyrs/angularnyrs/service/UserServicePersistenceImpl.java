package com.eci.nyrs.angularnyrs.service;

import com.eci.nyrs.angularnyrs.models.Nurse;
import com.eci.nyrs.angularnyrs.models.Patient;
import com.eci.nyrs.angularnyrs.models.User;
import com.eci.nyrs.angularnyrs.repositories.PatientRepository;
import com.eci.nyrs.angularnyrs.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserServicePersistenceImpl implements UserService {

    @Autowired
    private UserRepository userrepo;

    @Autowired
    private PatientRepository patirepo;

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public Patient createPatient(Patient user) {
        return null;
    }

    @Override
    public Nurse createNurse(Nurse user) {
        return null;
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        return null;
    }

    @Override
    public List<Nurse> getNursingPersonalByService(String service) {
        return null;
    }


}
