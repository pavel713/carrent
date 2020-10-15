package com.carrent.dao.repository;

import com.carrent.dao.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
