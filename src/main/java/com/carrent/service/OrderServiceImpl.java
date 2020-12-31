package com.carrent.service;

import com.carrent.dao.entities.Car;
import com.carrent.dao.entities.Order;
import com.carrent.dao.entities.User;
import com.carrent.dao.repository.CarRepository;
import com.carrent.dao.repository.OrderRepository;
import com.carrent.dto.CarDTO;
import com.carrent.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;
    private final PriceService priceService;
    private final CarRepository carRepository;

    @Override
    public OrderDTO save(String startDateString, String endDateString, long carId) throws DataAccessException {
        try {
            Date startDate = new Date(Long.parseLong(startDateString));
            Date endDate = new Date(Long.parseLong(endDateString));
            Long price = priceService.calculatePrice(startDate, endDate, carId);
            User currentUserEntity = userService.getCurrentUserEntity();
            Car car = carRepository.findCarById(carId);
            Order order = new Order();
            order.setStartDate(startDate);
            order.setEndDate(endDate);
            order.setCost(price);
            order.setCars(car);
            order.setUsers(currentUserEntity);

            Order savedOrder = orderRepository.save(order);
            return new OrderDTO(savedOrder);
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

}

