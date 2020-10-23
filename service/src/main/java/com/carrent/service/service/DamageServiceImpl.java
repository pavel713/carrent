package com.carrent.service.service;

import com.carrent.dao.entities.Car;
import com.carrent.dao.entities.Category;
import com.carrent.dao.entities.Damage;
import com.carrent.dao.repository.DamageRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.util.List;

@Service
@Transactional
public class DamageServiceImpl implements DamageService {
    private final DamageRepository damageRepository;

    public DamageServiceImpl(DamageRepository damageRepository) {
        this.damageRepository = damageRepository;
    }


    @Override
    public void save(Damage damage) throws DataAccessException {
        try {
            damageRepository.save(damage);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }
    }

    @Override
    public void delete(Long id) throws DataAccessException {
        try {
            damageRepository.delete(id);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }
    }

    @Override
    public List<Damage> findAll() throws DataAccessException {
        try {
            damageRepository.findAll();
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }
        return damageRepository.findAll();
    }

    @Override
    public Damage findDamageById(Long id) throws DataAccessException {
        try {
            damageRepository.findDamageById(id);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }
        return damageRepository.findDamageById(id);
    }


}
