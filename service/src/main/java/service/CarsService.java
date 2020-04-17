package com.prokat.service;

import com.prokat.connection.ConnectionManager;
import com.prokat.dao.CarsDAO;
import com.prokat.dao.CarsDAOImpl;
import com.prokat.entity.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CarsService extends ConnectionManager {

    private static final String FIND_CAR = "SELECT * FROM cars where model = ?";
    private static final String DELETE_CAR = "DELETE FROM cars WHERE (id) VALUES (?)";
    private static CarsService INSTANCE = null;

    private CarsService() {
    }

    public static CarsService getInstance() {
        if (INSTANCE == null) {
            synchronized (CarsService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CarsService();
                }
            }
        }
        return INSTANCE;
    }

    public void getById(int id) {
        CarsDAOImpl.getInstance().getById(id);
    }

    public void addCar(Car car) {
        CarsDAOImpl.getInstance().addCar(car);
    }

    public List<Car> findAllCars() {
        return CarsDAOImpl.getInstance().findAllCars();
    }

    public void delete(Car car) {
        CarsDAOImpl.getInstance().delete(car);
    }


}

