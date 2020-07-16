package com.carrent.dao.repository;

import com.carrent.dao.entities.Damage;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface DamageRepository extends CrudRepository<Damage, Long> {
    Damage findByDateAndContract(LocalDate date, String contract);
    void update(Damage damage);
    void delete(Long id);
    Optional<Damage> findById(Long id);

    void findByDateAndContract(Long id);
}
