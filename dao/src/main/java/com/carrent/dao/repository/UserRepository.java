package com.carrent.dao.repository;

import com.carrent.dao.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);

}
