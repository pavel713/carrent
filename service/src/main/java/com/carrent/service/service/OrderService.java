package com.carrent.service.service;

import com.carrent.dao.entities.Order;

import java.util.List;

public interface OrderService {

    void save(Order order);

    void delete(Long id);

    List<Order> findAll();

    Long getOrderById(Long id);
}
