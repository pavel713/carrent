package com.carrent.dao.repository;

import com.carrent.dao.entities.Damage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

public interface DamageRepository extends JpaRepository<Damage, Long> {


    void delete(Long id);
}
