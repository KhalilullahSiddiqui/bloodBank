package com.blood.testing.persistance.repos;

import com.blood.testing.persistance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findByEmail(String email);
    User findByFullName(String full_name);
    //User findById(Integer id);

}
