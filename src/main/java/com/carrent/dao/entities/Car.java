package com.carrent.dao.entities;

import com.carrent.dto.CarDTO;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@AllArgsConstructor

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

    public Car() {

    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public String getPlate_num() {
        return plate_num;
    }

    public void setPlate_num(String plate_num) {
        this.plate_num = plate_num;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

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



