package com.carrent.dao.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "order")
public class Order extends BaseEntity {

    @Column(name = "date_begin")
    private LocalDate date_begin;

    @Column(name = "date_end")
    private LocalDate date_end;

    @Column(name = "client_id")
    private Long id;

    @Column(name = "car_id")
    private int car_id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CAR_ID")
    @Fetch(FetchMode.JOIN)
    private Car car;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "damage_id")
    @Fetch(FetchMode.JOIN)
    private Damage damage;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    @Fetch(FetchMode.JOIN)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}


