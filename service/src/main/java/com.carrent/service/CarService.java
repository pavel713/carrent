package com.carrent.service;

import com.carrent.entities.Car;

import java.util.List;

public interface CarService {

    void save(Car car);

    void update(Car car);

    void delete(Long id);

    List<Car> listCars();

    Car getCarById(int id);

}
