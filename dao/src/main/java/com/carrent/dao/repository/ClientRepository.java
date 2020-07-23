package com.carrent.dao.repository;

import com.carrent.dao.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {


    void delete(Long id);
}
