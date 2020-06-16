package com.carrent.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cars")
@Inheritance(strategy = InheritanceType.JOINED)
public class Car extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

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




}




