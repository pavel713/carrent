package com.carrent.service;

import com.carrent.dao.entities.Car;
import com.carrent.dao.entities.Category;
import com.carrent.dao.repository.CarRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarsServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarsServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public void save(Car car) throws DataAccessException {
        try {
            carRepository.save(car);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }
    }

    @Override
    public void delete(Long id) throws DataAccessException {
        try {
            carRepository.findCarById(id);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }
    }

    @Override
    public List<Car> findAll() throws DataAccessException {
        try {
            carRepository.findAll();
            return carRepository.findAll();
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);

        }
    }


    @Override
    public Car getCarById(Long id) throws DataAccessException {
        try {
            carRepository.findCarById(id);
            return carRepository.findCarById(id);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }

    }

    @Override
    public List<Car> findCarByCategory(Category category) throws DataAccessException {
        try {
            carRepository.findCarByCategory(category);
            return carRepository.findCarByCategory(category);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);

        }

    }
}







