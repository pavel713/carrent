package com.carrent.service.service;


import com.carrent.dao.entities.Car;
import com.carrent.dao.repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarsServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarsServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void save(Car car) {
        carRepository.save(car);
    }

    @Override
    public void update(Car car) {
        carRepository.save(car);
    }

    @Override
    public void delete(Long id) {
        carRepository.delete(id);
    }

    @Override
    public List<Car> listCars() {
        return (List<Car>) carRepository.findAll();
    }


    @Override
    public void getCarById(Long id) {
        carRepository.findCarById(id);
    }
}







