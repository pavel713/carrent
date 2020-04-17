package com.prokat.dao;

import com.prokat.entity.Car;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CarsDAO {

    Car getById(long id) throws ClassNotFoundException, SQLException;

    void addCar(Car car) throws SQLException;

    List<Car> findAllCars();

    void delete(Car car);




}
