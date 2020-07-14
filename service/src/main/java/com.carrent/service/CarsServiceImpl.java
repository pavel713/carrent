package com.carrent.service;


import com.carrent.dao.CarDAO;
import com.carrent.entities.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsServiceImpl implements CarService {

    private CarDAO carDAO;

    public void setCarDAO(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    public void save(Car car) {
        this.carDAO.save(car);
    }

    @Override
    public void update(Car car) {
        this.carDAO.update(car);
    }

    @Override
    public void delete(Long id) {
        this.carDAO.delete(id);

    }

    @Override
    public List<Car> listCars() {
        return this.carDAO.listCars();
    }

    @Override
    public Car getCarById(Long id) {
        return this.carDAO.findById(id);
    }
}







