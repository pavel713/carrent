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
