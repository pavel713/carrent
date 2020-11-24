package com.carrent.dto;

import com.carrent.dao.entities.Car;
import com.carrent.dao.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarDTO {

    private Long id;

    private String model;

    private String color;

    private boolean rented;

    private String plate_num;

    private int year;

    private int price;

    private Category category;

    public CarDTO() {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public CarDTO(Car carDto) {
        this.id = carDto.getId();
        this.model = carDto.getModel();
        this.color = carDto.getColor();
        this.plate_num = carDto.getPlate_num();
        this.year = carDto.getYear();
        this.price = carDto.getPrice();
        this.rented = carDto.isRented();
        this.category = carDto.getCategory();

    }

}
