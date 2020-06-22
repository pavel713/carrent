package com.carrent.service;


import com.carrent.config.ServiceConfig;
import com.carrent.dao.CarDAO;
import com.carrent.dao.CarDAOImpl;
import com.carrent.entities.BaseEntity;
import com.carrent.entities.Car;
import com.carrent.util.SystemLogger;
import org.hibernate.HibernateException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsServiceImpl implements CarService{

 private CarService carService;
    @Override
    public void save(Car car) {
    this.carService.save(car);
    }

    @Override
    public void update(Car car) {
         this.carService.update(car);
    }

    @Override
    public void delete(Long id) {
     this.carService.delete(id);
    }

    @Override
    public List<Car> listCars() {
        List<Car> all;
        try {
            all = carService.listCars();
        } catch (HibernateException e) {
            SystemLogger.getInstance().setLogger(getClass(), e);
            throw new ServiceException("ERROR_GET_LIST_CARS");
        }
        return all;
    }

    @Override
    public Car getCarById(int id) {
      return (Car) this.carService.getCarById(id);

        }
    }







