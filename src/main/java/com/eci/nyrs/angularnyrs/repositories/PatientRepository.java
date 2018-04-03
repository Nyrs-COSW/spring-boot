package com.eci.nyrs.angularnyrs.repositories;


import java.util.List;

import com.eci.nyrs.angularnyrs.models.Patient;
import com.eci.nyrs.angularnyrs.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author 2101751
 */

public interface PatientRepository extends JpaRepository<Patient, String>{

}
