package com.cybersoft.crm04.Repository;

import com.cybersoft.crm04.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

    List<Users> findByEmailAndPassword(String email, String password);
}
