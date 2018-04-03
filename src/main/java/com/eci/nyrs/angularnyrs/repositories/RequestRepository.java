package com.eci.nyrs.angularnyrs.repositories;

import com.eci.nyrs.angularnyrs.models.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, String> {
}
