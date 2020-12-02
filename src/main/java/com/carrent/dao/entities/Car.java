package com.carrent.dao.entities;

import com.carrent.dto.CarDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
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

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToMany(mappedBy = "cars")
    private Set<Order> order;

    @OneToMany(mappedBy = "car", fetch = FetchType.EAGER)
    private List<Damage> damages;


    public Car(CarDTO car) {
        this.id = car.getId();
        this.model = car.getModel();
        this.color = car.getColor();
        this.plate_num = car.getPlate_num();
        this.year = car.getYear();
        this.price = car.getPrice();
        this.rented = car.isRented();
        this.category = car.getCategory();

    }
}



