package com.eci.nyrs.angularnyrs.repositories;


import java.util.List;

import com.eci.nyrs.angularnyrs.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author 2101751
 */

public interface UserRepository extends JpaRepository<User, String>{

}
