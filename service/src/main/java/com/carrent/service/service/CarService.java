package com.carrent.service.service;

import com.carrent.dao.entities.Car;

import java.util.List;

public interface CarService {

    void save(Car car);

    void delete(Long id);

    List<Car> findAll();

    Car getCarById(Long id);

}
