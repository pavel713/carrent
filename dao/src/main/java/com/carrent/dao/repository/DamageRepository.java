package com.carrent.dao.repository;

import com.carrent.dao.entities.Damage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface DamageRepository extends JpaRepository<Damage, Long> {
    Damage findDamageById(Long id);


    void delete(Long id);
}
