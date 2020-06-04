package com.carrent.dao;

import com.carrent.Car;
import org.hibernate.Session;


import java.util.List;

public interface CarDAO<T> extends BaseDAO<T>  {

    void save(Car car);

    void update(Car car);

    void delete(Car car);

    List<Car> findAll(int page, int perPage);

}
