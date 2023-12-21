package com.cybersoft.crm04.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cybersoft.crm04.Entity.Users;

import java.util.List;

public interface Users extends JpaRepository<Users,Integer> {

    List<Users> findByEmailAndPassWord(String email, String password);
}
