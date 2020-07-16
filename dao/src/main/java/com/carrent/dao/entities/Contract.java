package com.carrent.dao.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


@NoArgsConstructor
@Entity
@Table(name = "contract")
@Getter
@Setter
public class Contract extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column(name = "date_begin")
    private LocalDate date_begin;

    @Column(name = "date_end")
    private LocalDate date_end;

    @Column(name = "client_id")
    private int id;

    @Column(name = "car_id")
    private int car_id;

    @Column(name = "employee_id")
    private int employee_id;


    private Set<Car> cars;

    @OneToOne
    @JoinColumn(name = "damage_id")
    private Damage damage;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Damage client;

}


