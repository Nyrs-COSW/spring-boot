package com.eci.nyrs.angularnyrs.service;

import com.eci.nyrs.angularnyrs.models.Nursingservices;
import com.eci.nyrs.angularnyrs.repositories.NursingservicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NursingservicesServicePersistenceImpl implements NursingservicesService{

    @Autowired
    private NursingservicesRepository nurserrepo;

    @Override
    public List<Nursingservices> getNursingservices() {
        return nurserrepo.findAll();
    }
}
