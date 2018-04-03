package com.eci.nyrs.angularnyrs.service;

import com.eci.nyrs.angularnyrs.models.Nurse;

import java.util.List;

public interface NurseService {
    List<Nurse> getNurse();
    Nurse createNurse( Nurse patient );
    Nurse getNurse(String username);
}
