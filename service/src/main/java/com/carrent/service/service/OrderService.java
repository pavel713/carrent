package com.carrent.service.service;

import com.carrent.dao.entities.Order;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {

    void save(Order order);

    void delete(Long id);

    List<Order> findAll();

    Order findOrderById(Long id);

    long getDaysCountBetweenDates(LocalDate dateBefore, LocalDate dateAfter);
}
