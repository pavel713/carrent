package com.carrent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name = "cars")

public class Car extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Getter
    @Setter
    @Column(name = "model")
    private String model;

    @Getter
    @Setter
    @Column(name = "color")
    private String color;

    @Getter
    @Setter
    @Column(name = "rented")
    private boolean rented;

    @Getter
    @Setter
    @Column(name = "plate_num")
    private String plate_num;

    @Getter
    @Setter
    @Column(name = "year")
    private int year;

    @Getter
    @Setter
    @Column(name = "price")
    private int price;

    @OneToMany(mappedBy = "car")
    @Getter
    @Setter
    private Set<Contract> contracts = new HashSet<>();


    @Transient
    public String fullName() {
        return model + " " + year;

    }
}



