package com.carrent.service;

import com.carrent.dao.entities.Order;

import java.util.Date;
import java.util.List;

public interface OrderService {

    void save(Order order);

    void delete(Long id);

    List<Order> findAll();

    Order findOrderById(Long id);

    long calculateDateInterval(Date startDate, Date endDate);


}
