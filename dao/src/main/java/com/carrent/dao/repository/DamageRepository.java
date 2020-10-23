package com.carrent.dao.repository;

import com.carrent.dao.entities.Damage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DamageRepository extends JpaRepository<Damage, Long> {
    Damage findDamageById(Long id);


}
