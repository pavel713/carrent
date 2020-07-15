package com.carrent.dao.dao;

import com.carrent.dao.entities.BaseEntity;
import com.carrent.dao.entities.Car;

import java.util.List;

public interface CarDAO<T extends BaseEntity> extends BaseDAO<T>  {

    void save(Car car);

    void update(Car car);

    void delete(Long id);

    List<Car> listCars();

    Car findById(Long id);




}
