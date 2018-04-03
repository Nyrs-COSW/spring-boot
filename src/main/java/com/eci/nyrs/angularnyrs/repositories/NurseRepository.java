package com.eci.nyrs.angularnyrs.repositories;

import com.eci.nyrs.angularnyrs.models.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NurseRepository extends JpaRepository<Nurse, String> {
}
