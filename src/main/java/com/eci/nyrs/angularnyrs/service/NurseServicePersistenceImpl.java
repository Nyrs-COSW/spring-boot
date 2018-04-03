package com.eci.nyrs.angularnyrs.service;

import com.eci.nyrs.angularnyrs.models.Nurse;
import com.eci.nyrs.angularnyrs.repositories.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NurseServicePersistenceImpl implements NurseService {

    @Autowired
    private NurseRepository nurrepo;


    @Override
    public List<Nurse> getNurse() {
        return nurrepo.findAll();
    }

    @Override
    public Nurse createNurse(Nurse patient) {
        return null;
    }

    @Override
    public Nurse getNurse(String username) {
        return nurrepo.findOne(username);
    }
}
