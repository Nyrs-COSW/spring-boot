package com.eci.nyrs.angularnyrs.service;

import com.eci.nyrs.angularnyrs.models.Nursingservices;

import com.eci.nyrs.angularnyrs.models.User;
import com.eci.nyrs.angularnyrs.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServicePersistenceImpl implements UserService {

    @Autowired
    private UserRepository userrepo;


    @Override
    public List<User> getPatients() {
        List<User> users =userrepo.findAll();
        List<User> patients = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getRole().equals("patient")){
                patients.add(users.get(i));
            }
        }
        return patients;
    }

    @Override
    public User getUser(String username) {
        return userrepo.findOne(username);
    }

    @Override
    public User createPatient(User user) {
        userrepo.save(user);
        return userrepo.findOne(user.getUsername());
    }

    @Override
    public User createNurse(User user) {
        userrepo.save(user);
        return userrepo.findOne(user.getUsername());
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
    public List<User> getNursingPersonalByService(String service) {
        List<User> listn = userrepo.findAll();

        List<User> nursePersonal = new ArrayList<>();
        for (int i = 0; i < listn.size() ; i++) {
            List<Nursingservices> n = listn.get(i).getServices();
            for (int j = 0; j < n.size() ; j++){
                if(n.get(j).getName().equals(service)){
                    nursePersonal.add(listn.get(i));
                }
            }
        }
        return nursePersonal;
    }

    @Override
    public User editNurse(User nurse) {
        userrepo.save(nurse);
        return userrepo.findOne(nurse.getUsername());
    }

    @Override
    public List<User> getAllNurse() {
        List<User> users =userrepo.findAll();
        List<User> nurses = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getRole().equals("nurse")){
                nurses.add(users.get(i));
            }
        }
        return nurses;
    }

    @Override
    public User editPatient(User patient) {
        userrepo.save(patient);
        return userrepo.findOne(patient.getUsername());
    }



}
