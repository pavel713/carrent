package com.prokat.dao;

import com.prokat.connection.ConnectionManager;
import com.prokat.entity.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarsDAOImpl implements CarsDAO {

    private static final String ADD_CAR_QUERY = "INSERT INTO cars(model, color, plate_num, year, price)  VALUES (?,?,?,?,?)";
    private static final String FIND_CAR = "SELECT * FROM cars where id = ?";
    private static final String FIND_ALL_CARS = "SELECT * FROM cars";
    private static final String DELETE_CAR = "DELETE FROM cars WHERE id = ?";
    private static CarsDAOImpl INSTANCE = null;

    private CarsDAOImpl() {}
    public static CarsDAOImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (CarsDAOImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CarsDAOImpl();
                }
            }
        }
        return INSTANCE;
    }


    public Car getById(long id) {
        Car car = new Car();
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_CAR);
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                new Car(rs.getString("model"), rs.getString("color"), rs.getBoolean("Rented"),
                        rs.getString("plate_num"), rs.getInt("year"), rs.getInt("price"));
            }

        } catch (Exception ex) {
            System.out.print("Error");
        }
        return car;
    }

    @Override
    public void addCar(Car car) {

        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_CAR_QUERY);

            preparedStatement.setString(1, car.getModel());
            preparedStatement.setString(2, car.getColor());
            preparedStatement.setString(3, car.getPlate_num());
            preparedStatement.setInt(4, car.getYear());
            preparedStatement.setInt(5, car.getPrice());
            preparedStatement.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Car> findAllCars(){
        List carList = new ArrayList<>();

        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_CARS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setModel(resultSet.getString("model"));
                car.setColor(resultSet.getString("color"));
                car.setRented(resultSet.getBoolean("rented"));
                car.setPlate_num(resultSet.getString("plate_num"));
                car.setYear(resultSet.getInt("year"));
                car.setPrice(resultSet.getInt("price"));
                carList.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;

    }

    @Override
    public void delete(Car car) {

        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CAR);
            preparedStatement.setLong(1, car.getId());
            preparedStatement.executeUpdate();
            System.out.print("Done");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
