package com.carrent.service;

import com.carrent.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    OrderDTO save(String startDate, String endDate, long carId);

    void delete(Long id);

    List<OrderDTO> findAll();

    OrderDTO findOrderById(Long id);


}
