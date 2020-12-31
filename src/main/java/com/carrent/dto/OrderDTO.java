package com.carrent.dto;

import com.carrent.dao.entities.Car;
import com.carrent.dao.entities.Order;
import com.carrent.dao.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
public class OrderDTO {

    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    private long cost;

    private User users;

    private Car car;

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.startDate = order.getStartDate();
        this.endDate = order.getEndDate();
        this.cost = order.getCost();
        this.users = order.getUsers();
        this.car = order.getCars();

    }

    public OrderDTO() {
    }
}
