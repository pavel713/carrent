package com.carrent.dao.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "order")
public class Order extends BaseEntity {

    @Column(name = "date_begin")
    private Calendar date_begin;

    @Column(name = "date_end")
    private Calendar date_end;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User users;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "order_car",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id")
    )
    private Set<Car> cars;

    public Calendar getStartDate() {
        return date_begin;
    }

    public void setStartDate(Calendar startDate) {
        this.date_begin = date_begin;
    }

    public Calendar getEndDate() {
        return date_end;
    }

    public void setEndDate(Calendar endDate) {
        this.date_end = endDate;
    }


}


