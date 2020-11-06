package com.carrent.dao.repository;

import com.carrent.dao.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
    User findUserById(Long id);
    void deleteById(Long id);
}
