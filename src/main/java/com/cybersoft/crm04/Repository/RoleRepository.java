package com.cybersoft.crm04.Repository;

import com.cybersoft.crm04.Entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository <Roles,Integer> {
}
