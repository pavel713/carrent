package com.carrent.dao.repository;

import com.carrent.dao.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    Optional<Contract> findById(Long id);


    void delete(Long id);
}
