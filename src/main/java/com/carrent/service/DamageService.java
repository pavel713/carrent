package com.carrent.service;

import com.carrent.dao.entities.Damage;

import java.util.List;

public interface DamageService {

    void save(Damage damage);

    void delete(Long id);

    List<Damage> findAll();

    Damage findDamageById(Long id);
}
