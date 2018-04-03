package com.eci.nyrs.angularnyrs.service;

import com.eci.nyrs.angularnyrs.models.Nursingservices;
import com.eci.nyrs.angularnyrs.models.Nurse;
import com.eci.nyrs.angularnyrs.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


public class NursingservicesServiceImpl implements NursingservicesService {

    private List<Nursingservices> nursingservices = new ArrayList<>();


    @Autowired
    public NursingservicesServiceImpl()
    {
    }

    @PostConstruct
    private void populateSampleData()
    {
        nursingservices.add(new Nursingservices("Maternidad", "asdaasdf", "/assets/images/mother.svg"));
        nursingservices.add(new Nursingservices("Post-Operatorio", "asdaasdf", "/assets/images/posoperatorio.svg"));
        nursingservices.add(new Nursingservices("Transplantes", "asdaasdf", "/assets/images/heart.svg"));
        nursingservices.add(new Nursingservices("Terapia", "asdaasdf", "/assets/images/massage.svg"));
        nursingservices.add(new Nursingservices("Adulto-Mayor", "asdaasdf", "/assets/images/grandfather.svg"));
        nursingservices.add(new Nursingservices("Paliativos", "asdaasdf", "/assets/images/doctor.svg"));
        nursingservices.add(new Nursingservices("Compra-de-Equipos", "asdaasdf", "/assets/images/medicine.svg"));
    }

    @Override
    public List<Nursingservices> getNursingservices() {
        return nursingservices;
    }

}

