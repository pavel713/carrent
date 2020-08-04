package com.carrent.dao.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor

@ToString
@Entity
@Table(name = "сars")
public class Car extends BaseEntity {

    @Column(name = "model")
    private String model;

    @Column(name = "color")
    private String color;

    @Column(name = "rented")
    private boolean rented;

    @Column(name = "plate_num")
    private String plate_num;

    @Column(name = "year")
    private int year;

    @Column(name = "price")
    private int price;

    @Column(name = "car_class")
    @Enumerated(EnumType.STRING)
    private CarClass carClass;

}




