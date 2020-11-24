package com.carrent.dto;

import com.carrent.dao.entities.Order;
import com.carrent.dao.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class OrderDTO {

    private Long id;

    private Date startDate;

    private Date endDate;

    private double cost;

    private User users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public OrderDTO(Order orderDto) {
        this.id = orderDto.getId();
        this.startDate = orderDto.getStartDate();
        this.endDate = orderDto.getEndDate();
        this.cost = orderDto.getCost();
        this.users= orderDto.getUsers();



    }
}
