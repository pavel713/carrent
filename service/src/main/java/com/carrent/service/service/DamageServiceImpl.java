package com.carrent.service.service;

import com.carrent.dao.entities.Damage;
import com.carrent.dao.repository.DamageRepository;

import java.util.List;

public class DamageServiceImpl implements DamageService {
    private final DamageRepository damageRepository;

    public DamageServiceImpl(DamageRepository damageRepository) {
        this.damageRepository = damageRepository;
    }


    @Override
    public void save(Damage damage) {
        damageRepository.save(damage);
    }

    @Override
    public void delete(Long id) {
damageRepository.delete(id);
    }

    @Override
    public List<Damage> findAll() {
        return damageRepository.findAll();
    }

    @Override
    public Damage getDamageById(Long id) {
        return getDamageById(id);
    }
}
