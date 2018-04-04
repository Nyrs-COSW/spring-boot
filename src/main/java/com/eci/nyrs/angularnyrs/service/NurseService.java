package com.eci.nyrs.angularnyrs.service;

import com.eci.nyrs.angularnyrs.models.Nurse;

import java.util.List;

public interface NurseService {
    List<Nurse> getNurse();
    Nurse createNurse( Nurse nurse);
    Nurse editNurse(Nurse nurse);
    Nurse getNurse(String username);
    List<Nurse> getNursingPersonalByService(String service);
}
