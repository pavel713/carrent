package com.carrent.service;

import com.carrent.dao.entities.Car;
import com.carrent.dao.entities.Order;
import com.carrent.dao.entities.User;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface OrderService {

    void save(Order order);

    void delete(Long id);

    List<Order> findAll();

    Order findOrderById(Long id);

    double calculateCost(Date start, Date end);
}
