package com.carrent.service.service;

import com.carrent.dao.entities.Employee;
import com.carrent.dao.entities.Order;
import com.carrent.dao.repository.OrderRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
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
            orderRepository.delete(id);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }
    }

    @Override
    public List<Order> findAll() throws DataAccessException {
        try {
            orderRepository.findAll();
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }
        return orderRepository.findAll();
    }

    @Override
    public Order findOrderById(Long id) throws DataAccessException {
        try {
            orderRepository.findOrderById(id);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }
        return orderRepository.findOrderById(id);
    }


    @Override
    public long getDaysCountBetweenDates(LocalDate dateBefore, LocalDate dateAfter) {
        return DAYS.between(dateBefore, dateAfter);
    }


}
