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
    public void update(Damage damage) {
        damageRepository.update(damage);
    }

    @Override
    public void delete(Long id) {
        damageRepository.delete(id);
    }

    @Override
    public List<Damage> listDamage() {
        return (List<Damage>) damageRepository.findAll();
    }

    @Override
    public void getDamageById(Long id) {
        damageRepository.findByDateAndContract(id);
    }
}
