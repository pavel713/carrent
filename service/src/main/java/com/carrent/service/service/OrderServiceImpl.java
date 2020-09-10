package com.carrent.service.service;

import com.carrent.dao.entities.Car;
import com.carrent.dao.entities.Order;
import com.carrent.dao.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
@Service

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void delete(Long id) {
        orderRepository.delete(id);

    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Long getOrderById(Long id) {
        return (id);

    }

    @Override
    public long countDays(Order order) {
        long days;
        Calendar start = order.getStartDate();
        Calendar end = order.getEndDate();
        days = daysBetween(start, end);
        return days;
    }

    private long daysBetween(Calendar startDate, Calendar endDate) {
        endDate.add(Calendar.DATE, 1);
        long end = endDate.getTimeInMillis();
        long start = startDate.getTimeInMillis();
        return TimeUnit.MILLISECONDS.toDays(Math.abs(end - start));
    }


}
