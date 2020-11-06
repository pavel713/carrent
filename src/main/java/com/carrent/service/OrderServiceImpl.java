package com.carrent.service;

import com.carrent.dao.entities.Car;
import com.carrent.dao.entities.Order;
import com.carrent.dao.entities.User;
import com.carrent.dao.repository.CarRepository;
import com.carrent.dao.repository.OrderRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CarRepository carRepository;

    public OrderServiceImpl(OrderRepository orderRepository, CarRepository carRepository) {
        this.orderRepository = orderRepository;
        this.carRepository = carRepository;
    }


    @Override
    public void save(Order order) throws DataAccessException {
        try {
            orderRepository.save(order);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }
    }

    @Override
    public void delete(Long id) throws DataAccessException {
        try {
            orderRepository.deleteById(id);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }
    }

    @Override
    public List<Order> findAll() throws DataAccessException {
        try {
            orderRepository.findAll();
            return orderRepository.findAll();
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }

    }


    @Override
    public Order findOrderById(Long id) throws DataAccessException {
        try {
            orderRepository.findOrderById(id);
            return orderRepository.findOrderById(id);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }

    }

    @Override
    public double calculateCost(Date start, Date end) {
        return ChronoUnit.DAYS.between(start.toInstant(), end.toInstant());

    }
}

