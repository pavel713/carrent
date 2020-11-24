package com.carrent.service;

import com.carrent.dto.OrderDTO;

import java.util.Date;
import java.util.List;

public interface OrderService {

    void save(OrderDTO order);

    void delete(Long id);

    List<OrderDTO> findAll();

    OrderDTO findOrderById(Long id);

    long calculateDateInterval(Date startDate, Date endDate);


}
