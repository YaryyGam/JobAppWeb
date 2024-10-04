package com.yaryy.SpringBootREST.repo;

import com.yaryy.SpringBootREST.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}
