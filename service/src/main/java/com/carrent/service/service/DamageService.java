package com.carrent.service.service;


import com.carrent.dao.entities.Damage;

import java.util.List;

public interface DamageService  {
    void save(Damage damage);



    void delete(Long id);

    List<Damage> listDamage();

    void getDamageById(Long id);

}

