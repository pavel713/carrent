package com.carrent.dao.repository;

import com.carrent.dao.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>  {
}
