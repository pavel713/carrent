package com.carrent.service.service;

import com.carrent.dao.entities.Damage;
import com.carrent.dao.entities.Order;

import java.util.List;

public interface DamageService {

    void save(Damage damage);

    void delete(Long id);

    List<Damage> findAll();

    Damage findDamageById(Long id);
}
