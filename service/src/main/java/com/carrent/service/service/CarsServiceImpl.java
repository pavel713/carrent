package com.carrent.service.service;

import com.carrent.dao.entities.Car;
import com.carrent.dao.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class CarsServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarsServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public void save(Car car) {
        carRepository.save(car);
    }

    @Override
    public void delete(Long id) {
        carRepository.delete(id);
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }


    @Override
    public Car getCarById(Long id) throws ValidationException {
        Car car = carRepository.findCarById(id);
        if (car == null) {
            throw new ValidationException("Car not found!");
        }
        return car;
    }
}







