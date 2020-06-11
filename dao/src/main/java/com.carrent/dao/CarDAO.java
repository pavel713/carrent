package com.carrent.dao;

import com.carrent.Car;

import java.util.List;

public interface CarDAO<T> extends BaseDAO<T>  {

    void save(Car car);

    void update(Car car);

    void delete(Long id);

    List<Car> findAll();





}
