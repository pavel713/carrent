package com.carrent.dao.repository;

import com.carrent.dao.entities.Contract;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ContractRepository extends CrudRepository<Contract, Long> {
    Optional<Contract> findById(Long id);
    void update(Contract contract);
    void delete(Long id);
}
