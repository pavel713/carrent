package com.carrent.service;

import com.carrent.dao.entities.Order;
import com.carrent.dao.repository.CarRepository;
import com.carrent.dao.repository.OrderRepository;
import com.carrent.dto.OrderDTO;
import org.hibernate.service.spi.ServiceException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public void save(OrderDTO orderDto) throws DataAccessException {
        try {
            Order order = new Order(orderDto);
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
    public List<OrderDTO> findAll() throws DataAccessException {
        try {
            List<Order> allOrders = orderRepository.findAll();
            return allOrders.stream().map(OrderDTO::new).collect(Collectors.toList());
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }

    }


    @Override
    public OrderDTO findOrderById(Long id) throws DataAccessException {
        try {
            Order orderById = orderRepository.findOrderById(id);
            return new OrderDTO(orderById);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }

    }

    public long calculateDateInterval(Date startDate, Date endDate) {
        return ChronoUnit.DAYS.between(startDate.toInstant(), endDate.toInstant());
    }


}

