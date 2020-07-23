package com.carrent.service.service;

import com.carrent.dao.entities.Damage;
import com.carrent.dao.repository.DamageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
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
    public List<Damage> listDamage() {
        return damageRepository.findAll();
    }

    @Override
    public void getDamageById(Long id) {

    }


}

