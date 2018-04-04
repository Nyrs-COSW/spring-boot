package com.eci.nyrs.angularnyrs.service;

import com.eci.nyrs.angularnyrs.models.Nurse;
import com.eci.nyrs.angularnyrs.models.Nursingservices;
import com.eci.nyrs.angularnyrs.repositories.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Nurse createNurse(Nurse nurse) {
        nurrepo.save(nurse);
        return nurrepo.findOne(nurse.getUsername());
    }

    @Override
    public Nurse editNurse(Nurse nurse) {
        nurrepo.save(nurse);
        return nurrepo.findOne(nurse.getUsername());
    }

    @Override
    public Nurse getNurse(String username) {
        return nurrepo.findOne(username);
    }

    @Override
    public List<Nurse> getNursingPersonalByService(String service) {
        List<Nurse> listn = nurrepo.findAll();

        List<Nurse> nursePersonal = new ArrayList<>();
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
}
